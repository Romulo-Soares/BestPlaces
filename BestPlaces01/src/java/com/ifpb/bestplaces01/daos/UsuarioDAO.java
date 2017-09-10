
package com.ifpb.bestplaces01.daos;

import com.ifpb.bestplaces01.conexao.ConFactory;
import com.ifpb.bestplaces01.entidades.Usuario;
import com.ifpb.bestplaces01.interfaces.IUsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO{
    
    @Override
    public Usuario read(String email) throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario WHERE email = ?");

        stmt.setString(1, email);
        
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            
            Usuario usuario = new Usuario();
            usuario.setNome(rs.getString("nome"));
            usuario.setNascimento(rs.getString("nascimento"));
            usuario.setSexo(rs.getString("sexo"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setProfissao(rs.getString("profissao"));
            usuario.setFotoPerfil(rs.getString("foto_Perfil"));

            con.close();
            return usuario;
            
        } else {
            
            con.close();
            return null;
        }

    }
    
    @Override
    public List<Usuario> list() throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario");

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
    public boolean insert(Usuario u) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO usuario (nome, nascimento, sexo, "
                + "email, senha, cidade, foto_perfil, profissao) "
                        + "VALUES (?,?,?,?,?,?,?,?)");

        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getNascimento());
        stmt.setString(3, u.getSexo());
        stmt.setString(4, u.getEmail());
        stmt.setString(5, u.getSenha());
        stmt.setString(6, u.getCidade());
        stmt.setString(7, u.getFotoPerfil());
        stmt.setString(8, u.getProfissao());

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;

    }

    @Override
    public boolean delete(String email) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM usuario WHERE email = ?");
        
        stmt.setString(1, email);

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;

    }

    @Override
    public boolean update(Usuario u) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE usuario SET (nome, nascimento, sexo, senha, cidade, "
                        + "profissao, foto_Perfil) = (?,?,?,?,?,?,?) "
                        + "WHERE email = ?");

        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getNascimento());
        stmt.setString(3, u.getSexo());
        stmt.setString(4, u.getSenha());
        stmt.setString(5, u.getCidade());
        stmt.setString(6, u.getProfissao());
        stmt.setString(7, u.getFotoPerfil());
        stmt.setString(8, u.getEmail());

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;
    }
    
}