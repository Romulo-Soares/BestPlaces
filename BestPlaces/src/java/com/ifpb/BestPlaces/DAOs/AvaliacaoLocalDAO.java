package com.ifpb.BestPlaces.DAOs;

import com.ifpb.BestPlaces.Conexao.ConFactory;
import com.ifpb.BestPlaces.Entidades.AvaliacaoLocal;
import com.ifpb.BestPlaces.Interfaces.IAvaliacaoLocal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvaliacaoLocalDAO implements IAvaliacaoLocal {

    @Override
    public boolean insert(AvaliacaoLocal a)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO avaliacao_local (id_local, usuario, nota_local) "
                + "VALUES (?,?,?)");

        stmt.setInt(1, a.getIdLocal());
        stmt.setString(2, a.getAvaliador());
        stmt.setInt(3, a.getNota());

        boolean retorno = stmt.executeUpdate() > 0;

        con.close();
        return retorno;

    }
    
    @Override
    public int countStar(int idLocal) throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select nota_local from avaliacao_local where id_local = ?");

        stmt.setInt(1, idLocal);

        ResultSet rs = stmt.executeQuery();

        double notaMedia = 0;
        int count = 0, retorno = 0;
        
        while (rs.next()) {
            count++;
            notaMedia += rs.getInt("nota_local");

        }
        con.close();
        if(notaMedia%count == 0){
            retorno = (int) notaMedia/count;
        }else if(count != 0){
            retorno = ((int)notaMedia/count)+1;
        }    
        return retorno;
    }
    
    @Override
    public boolean localAvaliado(AvaliacaoLocal a) 
            throws ClassNotFoundException, SQLException{

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM Avaliacao_Local WHERE usuario = ? and id_local = ?");

        stmt.setString(1, a.getAvaliador());
        stmt.setInt(2, a.getIdLocal());
        
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
    public boolean update(AvaliacaoLocal a) throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE avaliacao_local SET (nota_local) = (?) "
                        + "WHERE id_local = ? and usuario = ?");

        stmt.setInt(1, a.getNota());
        stmt.setInt(2, a.getIdLocal());
        stmt.setString(3, a.getAvaliador());

        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;
    }

}
