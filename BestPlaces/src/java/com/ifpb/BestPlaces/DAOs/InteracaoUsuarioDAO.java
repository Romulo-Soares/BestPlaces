package com.ifpb.BestPlaces.DAOs;

import com.ifpb.BestPlaces.Conexao.ConFactory;
import com.ifpb.BestPlaces.Entidades.Usuario;
import com.ifpb.BestPlaces.Interfaces.IInteracaoUsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InteracaoUsuarioDAO implements IInteracaoUsuarioDAO {

    @Override
    public boolean enviarSolicitacaoAmizade(String usuarioInteraginte,
            String usuarioInteragido) throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO interacao (Usuario_Interaginte, Usuario_Interagido, "
                + "Amizade, Solicitacao_Amizade) VALUES (?,?,?,?)");

        stmt.setString(1, usuarioInteraginte);
        stmt.setString(2, usuarioInteragido);
        stmt.setBoolean(3, false);
        stmt.setBoolean(4, true);

        boolean retorno = stmt.executeUpdate() > 0;

        con.close();
        return retorno;

    }

    @Override
    public boolean gerenciarInteracao(String usuarioInteraginte,
            String usuarioInteragido, boolean amizade, boolean solicitacao)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE interacao SET (Amizade, Solicitacao_Amizade) = (?,?) "
                + "WHERE Usuario_Interaginte = ? and Usuario_Interagido = ?");

        stmt.setBoolean(1, amizade);
        stmt.setBoolean(2, solicitacao);
        stmt.setString(3, usuarioInteraginte);
        stmt.setString(4, usuarioInteragido);

        boolean retorno = stmt.executeUpdate() > 0;

        con.close();
        return retorno;
    }

    @Override
    public boolean isRequested(String usuarioInteraginte, String usuarioInteragido)
            throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM interacao WHERE usuario_interaginte = ? "
                + "and usuario_interagido = ? and solicitacao_amizade = ? "
                + "and amizade = ?");

        stmt.setString(1, usuarioInteraginte);
        stmt.setString(2, usuarioInteragido);
        stmt.setBoolean(3, true);
        stmt.setBoolean(4, false);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            con.close();
            return true;
        } else {
            con.close();
            return false;
        }
    }

    @Override
    public boolean isUpgradeable(String usuarioInteraginte, String usuarioInteragido)
            throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM interacao WHERE usuario_interaginte = ? "
                + "and usuario_interagido = ?");

        stmt.setString(1, usuarioInteraginte);
        stmt.setString(2, usuarioInteragido);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            con.close();
            return true;
        } else {
            con.close();
            return false;
        }
    }

    @Override
    public int countRequest(String usuarioInteragido)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT COUNT(*) FROM interacao "
                + "WHERE usuario_interagido = ? "
                + "and solicitacao_amizade = true");

        stmt.setString(1, usuarioInteragido);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            con.close();
            return rs.getInt(1);
        } else {
            con.close();
            return 0;
        }

    }

    @Override
    public List<Usuario> buscaSolicitacoes(String usuarioInteragido)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select * from usuario where email IN "
                + "(select usuario_interaginte from interacao "
                + "where usuario_interagido = ? AND "
                + "amizade = false AND solicitacao_amizade = true)");

        stmt.setString(1, usuarioInteragido);

        ResultSet rs = stmt.executeQuery();

        List<Usuario> usuarios = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setNome(rs.getString("nome"));
            usuario.setNascimento(rs.getString("nascimento"));
            usuario.setSexo(rs.getString("sexo"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setProfissao(rs.getString("profissao"));
            usuario.setFotoPerfil(rs.getString("foto_Perfil"));
            usuario.setCidade(rs.getString("cidade"));

            usuarios.add(usuario);

        }
        con.close();
        return usuarios;
    }

    @Override
    public boolean isFriend(String usuarioInteraginte, String usuarioInteragido)
            throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select * from interacao "
                + "where ((usuario_interaginte = ? and "
                + "usuario_interagido = ?) or "
                + "(usuario_interaginte = ? "
                + "and usuario_interagido = ?)) and "
                + "(amizade = true and solicitacao_amizade = false)");

        stmt.setString(1, usuarioInteraginte);
        stmt.setString(2, usuarioInteragido);
        stmt.setString(3, usuarioInteragido);
        stmt.setString(4, usuarioInteraginte);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            con.close();
            return true;
        } else {
            con.close();
            return false;
        }
    }

    @Override
    public List<Usuario> listarAmigos(String usuarioInteragido)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario "
                + "WHERE email IN"
                + "(SELECT CASE "
                + "WHEN usuario_interaginte = ? and amizade = true "
                        + "THEN usuario_interagido "
                + "WHEN usuario_interagido = ? and amizade = true "
                        + "THEN usuario_interaginte "
                + "END AS amigos "
                + "FROM interacao)");

        stmt.setString(1, usuarioInteragido);
        stmt.setString(2, usuarioInteragido);

        ResultSet rs = stmt.executeQuery();

        List<Usuario> usuarios = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setNome(rs.getString("nome"));
            usuario.setNascimento(rs.getString("nascimento"));
            usuario.setSexo(rs.getString("sexo"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setProfissao(rs.getString("profissao"));
            usuario.setFotoPerfil(rs.getString("foto_Perfil"));
            usuario.setCidade(rs.getString("cidade"));

            usuarios.add(usuario);

        }
        con.close();
        return usuarios;
    }
    
    @Override
    public List<Usuario> dezMaisConversadores(String usuarioInteragido)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario "
                + "WHERE email IN"
                + "(SELECT CASE "
                + "WHEN usuario_interaginte = ? and amizade = true "
                        + "THEN usuario_interagido "
                + "WHEN usuario_interagido = ? and amizade = true "
                        + "THEN usuario_interaginte "
                + "END AS amigos "
                + "FROM interacao) LIMIT 10");

        stmt.setString(1, usuarioInteragido);
        stmt.setString(2, usuarioInteragido);

        ResultSet rs = stmt.executeQuery();

        List<Usuario> usuarios = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setNome(rs.getString("nome"));
            usuario.setNascimento(rs.getString("nascimento"));
            usuario.setSexo(rs.getString("sexo"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setProfissao(rs.getString("profissao"));
            usuario.setFotoPerfil(rs.getString("foto_Perfil"));
            usuario.setCidade(rs.getString("cidade"));

            usuarios.add(usuario);

        }
        con.close();
        return usuarios;
    }

}
