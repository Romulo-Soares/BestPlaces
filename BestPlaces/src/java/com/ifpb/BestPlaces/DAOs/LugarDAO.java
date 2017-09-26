
package com.ifpb.BestPlaces.DAOs;

import com.ifpb.BestPlaces.Conexao.ConFactory;
import com.ifpb.BestPlaces.Entidades.Lugar;
import com.ifpb.BestPlaces.Interfaces.ILugarDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LugarDAO implements ILugarDAO{
    
    @Override
    public Lugar read(int id) throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM lugar WHERE id = ?");

        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) { 
            Lugar lugar = new Lugar();
            lugar.setUsuario(rs.getString("usuario"));
            lugar.setNome(rs.getString("nome"));
            lugar.setRua(rs.getString("rua"));
            lugar.setCidade(rs.getString("cidade"));
            lugar.setDescricao(rs.getString("descricao"));
            lugar.setEstado(rs.getString("estado"));
            lugar.setTipo(rs.getString("tipo"));
            
            con.close();
            return lugar;
            
        } else {
            con.close();
            return null;
        }

    }
    
    @Override
    public List<Lugar> list() throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM lugar");

        ResultSet rs = stmt.executeQuery();
        
        List<Lugar> lugares = new ArrayList<>();

        while (rs.next()) {
            Lugar lugar = new Lugar();
            lugar.setUsuario(rs.getString("usuario"));
            lugar.setNome(rs.getString("nome"));
            lugar.setRua(rs.getString("rua"));
            lugar.setCidade(rs.getString("cidade"));
            lugar.setDescricao(rs.getString("descricao"));
            lugar.setEstado(rs.getString("estado"));
            lugar.setTipo(rs.getString("tipo"));
    
            lugares.add(lugar);
            
        }
        con.close();
        return lugares;

    }

    @Override
    public boolean insert(Lugar l) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO lugar (usuario, nome, rua, "
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
                "DELETE FROM lugar WHERE id = ?");
        
        stmt.setInt(1, id);

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;

    }

    @Override
    public boolean update(int id, Lugar l) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE lugar SET (usuario, nome, rua, cidade, descricao, "
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
    public boolean lugarExists(int id) throws ClassNotFoundException, SQLException{

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM lugar WHERE id = ?");

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