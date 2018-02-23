package com.ifpb.bestplaces.daos;

import com.ifpb.bestplaces.conexao.ConFactory;
import com.ifpb.bestplaces.entidades.Foto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ifpb.bestplaces.interfaces.IFotoDAO;
import java.util.ArrayList;
import java.util.List;

public class FotoDAO implements IFotoDAO {

    @Override
    public Foto read(int id, String tabela) throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM " + tabela + " WHERE id = ?");

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
    public boolean insert(Foto f, String tabela) throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO " + tabela + " (id_local, foto)"
                + "VALUES (?,?)");

        stmt.setInt(1, f.getId());
        stmt.setString(2, f.getFoto());

        boolean retorno = stmt.executeUpdate() > 0;

        con.close();
        return retorno;

    }
    
    @Override
    public boolean insertE(Foto f, String tabela) throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO " + tabela + " (id_evento, foto)"
                + "VALUES (?,?)");

        stmt.setInt(1, f.getId());
        stmt.setString(2, f.getFoto());

        boolean retorno = stmt.executeUpdate() > 0;

        con.close();
        return retorno;

    }
    
    @Override
    public boolean insertFotosPresencaEvento(Foto f, String tabela) 
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO " + tabela + " (id_Evento, foto)"
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
                "DELETE FROM " + tabela + " WHERE id = ?");

        stmt.setInt(1, id);

        boolean retorno = stmt.executeUpdate() > 0;

        con.close();
        return retorno;

    }

    @Override
    public List<Foto> listarFotosLocal(int idLocal)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT foto FROM fotos_local WHERE id_local = (?)");

        stmt.setInt(1, idLocal);

        ResultSet rs = stmt.executeQuery();

        List<Foto> fotos = new ArrayList<>();

        while (rs.next()) {
            Foto foto = new Foto();
            foto.setFoto(rs.getString("foto"));

            fotos.add(foto);

        }
        con.close();
        return fotos;
    }

    @Override
    public int interatorFotos_Local(String tabela)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select count(*)+1 "
                + "from " + tabela);

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
    public Foto retornaFotoLocal(int idLocal) throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT foto FROM fotos_local WHERE id_local = ?");

        stmt.setInt(1, idLocal);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Foto foto = new Foto();
            foto.setFoto(rs.getString("foto"));

            con.close();
            return foto;

        } else {
            con.close();
            return null;
        }

    }

}
