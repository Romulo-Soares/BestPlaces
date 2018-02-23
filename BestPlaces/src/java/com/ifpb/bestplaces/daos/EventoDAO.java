
package com.ifpb.bestplaces.daos;

import com.ifpb.bestplaces.conexao.ConFactory;
import com.ifpb.bestplaces.entidades.Evento;
import com.ifpb.bestplaces.interfaces.IEventoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO implements IEventoDAO{
    
    @Override
    public Evento read(int idEvento) throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM evento WHERE id = ?");

        stmt.setInt(1, idEvento);
        
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) { 
            Evento evento = new Evento();
            evento.setId(rs.getInt("id"));
            evento.setUsuario(rs.getString("usuario"));
            evento.setIdLocal(rs.getInt("id_Local"));
            evento.setNome(rs.getString("nome"));
            evento.setData(rs.getString("data"));
            evento.setHora(rs.getString("hora"));
            evento.setLocal(rs.getString("local"));
            evento.setDescricao(rs.getString("descricao"));
            
            con.close();
            return evento;
            
        } else {
            con.close();
            return null;
        }

    }
    
    @Override
    public List<Evento> readEventoByName(String nome) throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM evento WHERE nome ILIKE '"+nome+"%'");
        
        ResultSet rs = stmt.executeQuery();
        
        List<Evento> eventos = new ArrayList<>();

        while (rs.next()) { 
            Evento evento = new Evento();
            evento.setId(rs.getInt("id"));
            evento.setUsuario(rs.getString("usuario"));
            evento.setIdLocal(rs.getInt("id_Local"));
            evento.setNome(rs.getString("nome"));
            evento.setData(rs.getString("data"));
            evento.setHora(rs.getString("hora"));
            evento.setLocal(rs.getString("local"));
            evento.setDescricao(rs.getString("descricao"));
            
            eventos.add(evento);
            
        } 
            con.close();
            return eventos;
    }
    
    @Override
    public List<Evento> list() throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM evento");

        ResultSet rs = stmt.executeQuery();
        
        List<Evento> eventos = new ArrayList<>();

        while (rs.next()) {
            Evento evento = new Evento();
            evento.setUsuario(rs.getString("usuario"));
            evento.setIdLocal(rs.getInt("idLocal"));
            evento.setNome(rs.getString("nome"));
            evento.setData(rs.getString("data"));
            evento.setHora(rs.getString("hora"));
            evento.setLocal(rs.getString("local"));
            evento.setDescricao(rs.getString("descricao"));
    
            eventos.add(evento);
            
        }
        con.close();
        return eventos;

    }

    @Override
    public boolean insert(Evento e) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO evento (usuario, id_Local, nome, "
                + "data, hora, local, descricao) "
                        + "VALUES (?,?,?,?,?,?,?)");

        stmt.setString(1, e.getUsuario());
        stmt.setInt(2, e.getIdLocal());
        stmt.setString(3, e.getNome());
        stmt.setString(4, e.getData());
        stmt.setString(5, e.getHora());
        stmt.setString(6, e.getLocal());
        stmt.setString(7, e.getDescricao());

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;

    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM evento WHERE id = ?");
        
        stmt.setInt(1, id);

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;

    }

    @Override
    public boolean update(int id, Evento e) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE evento SET (nome, data, hora, "
                        + "descricao) = (?,?,?,?) "
                        + "WHERE id = ?");

        stmt.setString(1, e.getNome());
        stmt.setString(2, e.getData());
        stmt.setString(3, e.getHora());
        stmt.setString(4, e.getDescricao());
        stmt.setInt(5, id);

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;
    }
    
    @Override
    public boolean eventoExists(String usuario, String nome) throws ClassNotFoundException, SQLException{

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM evento WHERE usuario = ? AND nome = ?");

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
    public List<Evento> listarEventos(String usuarioLogado)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM evento WHERE usuario = (?)");

        stmt.setString(1, usuarioLogado);

        ResultSet rs = stmt.executeQuery();

        List<Evento> eventos = new ArrayList<>();

        while (rs.next()) {
            Evento evento = new Evento();
            evento.setId(rs.getInt("id"));
            evento.setUsuario(rs.getString("usuario"));
            evento.setIdLocal(rs.getInt("id_Local"));
            evento.setNome(rs.getString("nome"));
            evento.setData(rs.getString("data"));
            evento.setHora(rs.getString("hora"));
            evento.setLocal(rs.getString("local"));
            evento.setDescricao(rs.getString("descricao"));

            eventos.add(evento);

        }
        con.close();
        return eventos;
    }
 
}