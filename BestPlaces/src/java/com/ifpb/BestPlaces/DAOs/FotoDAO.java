
package com.ifpb.BestPlaces.DAOs;

import com.ifpb.BestPlaces.Conexao.ConFactory;
import com.ifpb.BestPlaces.Entidades.Foto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ifpb.BestPlaces.Interfaces.IFotoDAO;

public class FotoDAO implements IFotoDAO{
    
    @Override
    public Foto read(int id, String tabela) throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM "+tabela+" WHERE id = ?");

        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) { 
            Foto foto = new Foto();
            foto.setId(rs.getInt("id"));
            foto.setFoto(rs.getString("foto"));

            con.close();
            return foto;
            
        } else {
            con.close();
            return null;
        }

    }
    
    @Override
    public List<Foto> list(String tabela) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM "+tabela);

        ResultSet rs = stmt.executeQuery();
        
        List<Foto> fotos = new ArrayList<>();

        while (rs.next()) {
            Foto foto = new Foto();
            foto.setId(rs.getInt("id"));
            foto.setFoto(rs.getString("foto"));

            fotos.add(foto);
            
        }
        con.close();
        return fotos;

    }

    @Override
    public boolean insert(Foto f, String tabela) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO "+tabela+" (id, foto)"
                    + "VALUES (?,?)");

        stmt.setInt(1, f.getId());
        stmt.setString(2, f.getFoto());

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;

    }

    @Override
    public boolean delete(int id, String tabela) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM "+tabela+" WHERE id = ?");
        
        stmt.setInt(1, id);

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;

    }

    @Override
    public boolean update(int id, Foto f, String tabela) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE "+tabela+" SET (id, foto) = (?,?) "
                    + "WHERE id = ?");

        stmt.setInt(1, f.getId());
        stmt.setString(2, f.getFoto());

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;
    }
    
    @Override
    public boolean fotoExists(int id, String tabela) throws ClassNotFoundException, SQLException{

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM "+tabela+" WHERE id = ?");

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) { 
            con.close();
            return true;
        } else {
            con.close();
            return false;
        }
    }
    
}

