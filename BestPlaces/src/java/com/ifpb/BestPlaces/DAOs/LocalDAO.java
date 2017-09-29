
package com.ifpb.BestPlaces.DAOs;

import com.ifpb.BestPlaces.Conexao.ConFactory;
import com.ifpb.BestPlaces.Entidades.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ifpb.BestPlaces.Interfaces.ILocalDAO;

public class LocalDAO implements ILocalDAO{
    
    @Override
    public Local read(String usuario, String nome) throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM local WHERE usuario = ? AND nome = ?");

        stmt.setString(1, usuario);
        stmt.setString(2, nome);
        
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) { 
            Local local = new Local();
            local.setUsuario(rs.getString("usuario"));
            local.setNome(rs.getString("nome"));
            local.setRua(rs.getString("rua"));
            local.setCidade(rs.getString("cidade"));
            local.setDescricao(rs.getString("descricao"));
            local.setEstado(rs.getString("estado"));
            local.setTipo(rs.getString("tipo"));
            
            con.close();
            return local;
            
        } else {
            con.close();
            return null;
        }

    }
    
    @Override
    public List<Local> list() throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM local");

        ResultSet rs = stmt.executeQuery();
        
        List<Local> locais = new ArrayList<>();

        while (rs.next()) {
            Local local = new Local();
            local.setUsuario(rs.getString("usuario"));
            local.setNome(rs.getString("nome"));
            local.setRua(rs.getString("rua"));
            local.setCidade(rs.getString("cidade"));
            local.setDescricao(rs.getString("descricao"));
            local.setEstado(rs.getString("estado"));
            local.setTipo(rs.getString("tipo"));
    
            locais.add(local);
            
        }
        con.close();
        return locais;

    }

    @Override
    public boolean insert(Local l) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO local (usuario, nome, rua, "
                + "cidade, descricao, estado, tipo) "
                        + "VALUES (?,?,?,?,?,?,?)");

        stmt.setString(1, l.getUsuario());
        stmt.setString(2, l.getNome());
        stmt.setString(3, l.getRua());
        stmt.setString(4, l.getCidade());
        stmt.setString(5, l.getDescricao());
        stmt.setString(6, l.getEstado());
        stmt.setString(7, l.getTipo());

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;

    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM local WHERE id = ?");
        
        stmt.setInt(1, id);

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;

    }

    @Override
    public boolean update(int id, Local l) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE local SET (usuario, nome, rua, cidade, descricao, "
                        + "estado, tipo) = (?,?,?,?,?,?,?) "
                        + "WHERE id = ?");

        stmt.setString(1, l.getUsuario());
        stmt.setString(2, l.getNome());
        stmt.setString(3, l.getRua());
        stmt.setString(4, l.getCidade());
        stmt.setString(5, l.getDescricao());
        stmt.setString(6, l.getEstado());
        stmt.setString(7, l.getTipo());

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;
    }
    
    @Override
    public boolean localExists(String usuario, String nome) throws ClassNotFoundException, SQLException{

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM local WHERE usuario = ? AND nome = ?");

        stmt.setString(1, usuario);
        stmt.setString(2, nome);
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
    public List<Local> listarLocais(String usuarioLogado)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM local WHERE usuario = (?)");

        stmt.setString(1, usuarioLogado);

        ResultSet rs = stmt.executeQuery();

        List<Local> locais = new ArrayList<>();

        while (rs.next()) {
            Local local = new Local();
            local.setId(rs.getInt("id"));
            local.setUsuario(rs.getString("usuario"));
            local.setNome(rs.getString("nome"));
            local.setRua(rs.getString("rua"));
            local.setCidade(rs.getString("cidade"));
            local.setDescricao(rs.getString("descricao"));
            local.setEstado(rs.getString("estado"));
            local.setTipo(rs.getString("tipo"));

            locais.add(local);

        }
        con.close();
        return locais;
    }
    
}