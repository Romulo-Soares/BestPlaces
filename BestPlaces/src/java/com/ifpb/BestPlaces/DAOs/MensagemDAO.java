package com.ifpb.BestPlaces.DAOs;

import com.ifpb.BestPlaces.Conexao.ConFactory;
import com.ifpb.BestPlaces.Entidades.Mensagem;
import com.ifpb.BestPlaces.Entidades.Usuario;
import com.ifpb.BestPlaces.Interfaces.IMensagemDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MensagemDAO implements IMensagemDAO {

    @Override
    public boolean insert(Mensagem m)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO Mensagem (remetente, destinatario, mensagem) "
                + "VALUES (?,?,?)");

        stmt.setString(1, m.getRemetente());
        stmt.setString(2, m.getDestinatario());
        stmt.setString(3, m.getMensagem());

        boolean retorno = stmt.executeUpdate() > 0;

        con.close();
        return retorno;

    }

    @Override
    public int countUserMensseger(String destinatario)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT COUNT(DISTINCT m.remetente) "
                + "FROM mensagem m "
                + "WHERE destinatario = ?");

        stmt.setString(1, destinatario);

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
    public List<Usuario> findUserMessenger(String destinatario)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario WHERE email IN "
                + "(SELECT DISTINCT m.remetente "
                + "FROM mensagem m "
                + "WHERE destinatario = ?)");

        stmt.setString(1, destinatario);

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
    public List<Mensagem> findMessages(String remetente, String destinatario)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * "
                + "FROM mensagem "
                + "WHERE (remetente = ? and "
                + "destinatario = ?) or "
                + "(remetente = ? and "
                + "destinatario = ?)");

        stmt.setString(1, remetente);
        stmt.setString(2, destinatario);
        stmt.setString(3, destinatario);
        stmt.setString(4, remetente);

        ResultSet rs = stmt.executeQuery();

        List<Mensagem> mensagens = new ArrayList<>();

        while (rs.next()) {
            Mensagem msg = new Mensagem();
            msg.setRemetente(rs.getString("remetente"));
            msg.setDestinatario(rs.getString("destinatario"));
            msg.setMensagem(rs.getString("mensagem"));
            

            mensagens.add(msg);

        }
        con.close();
        return mensagens;
    }

}
