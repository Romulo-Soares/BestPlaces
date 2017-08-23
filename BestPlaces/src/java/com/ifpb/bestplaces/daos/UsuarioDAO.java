
package com.ifpb.bestplaces.daos;

import com.ifpb.bestplaces.conexao.ConFactory;
import com.ifpb.bestplaces.entidades.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    public Usuario read(String email) throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario WHERE email = ?");

        stmt.setString(1, email);
        
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            
            Usuario usuario = new Usuario();
            usuario.setNome(rs.getString("nome"));
            usuario.setNascimento(rs.getDate("nascimento").toLocalDate());
            usuario.setSexo(rs.getString("sexo"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setProfissao(rs.getString("profissao"));
            usuario.setFotoPerfil(rs.getString("fotoPerfil"));

            con.close();
            
            return usuario;
            
        } else {
            
            con.close();
            
            return null;
        }

    }

    public List<Usuario> list() throws ClassNotFoundException, SQLException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario");

        ResultSet rs = stmt.executeQuery();
        
        List<Usuario> usuarios = new ArrayList<>();

        while (rs.next()) {

            Usuario usuario = new Usuario();
            usuario.setNome(rs.getString("nome"));
            usuario.setNascimento(rs.getDate("nascimento").toLocalDate());
            usuario.setSexo(rs.getString("sexo"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setProfissao(rs.getString("profissao"));
            usuario.setFotoPerfil(rs.getString("fotoPerfil"));
            usuario.setCidade(rs.getString("cidade"));
            
            usuarios.add(usuario);
            
        }

        con.close();
        
        return usuarios;

    }

    public boolean insert(Usuario u) throws ClassNotFoundException, SQLException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO usuario (nome, nascimento, sexo,"
                + " email, senha, cidade, fotoperfil, profissao) "
                        + "VALUES (?,?,?,?,?,?,?,?)");

        stmt.setString(1, u.getNome());
        stmt.setDate(2, Date.valueOf(u.getNascimento()));
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

   
    public boolean deleteUsuario(String email) throws ClassNotFoundException, SQLException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM usuario WHERE email = ?");
        
        stmt.setString(1, email);

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        
        return retorno;

    }

    public boolean updateUsuario(Usuario u) throws ClassNotFoundException, SQLException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE usuario SET (nome, nascimento, sexo, senha, cidade, "
                        + "profissao, fotoPerfil) = (?,?,?,?,?,?,?) "
                        + "WHERE email = ?");

        stmt.setString(1, u.getNome());
        stmt.setDate(2, Date.valueOf(u.getNascimento()));
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

    

