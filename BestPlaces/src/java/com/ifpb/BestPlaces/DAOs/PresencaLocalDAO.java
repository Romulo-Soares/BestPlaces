
package com.ifpb.BestPlaces.DAOs;

import com.ifpb.BestPlaces.Conexao.ConFactory;
import com.ifpb.BestPlaces.Entidades.PresencaLocal;
import com.ifpb.BestPlaces.Entidades.RecomendacaoLocal;
import com.ifpb.BestPlaces.Interfaces.IPresencaLocalDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PresencaLocalDAO implements IPresencaLocalDAO{
    
    @Override
    public boolean presenciarLocal(PresencaLocal pl) 
            throws SQLException, ClassNotFoundException {
        
        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO presenca_local (id_local, usuario, comentario, status, data) "
                        + "VALUES (?,?,?,?,?)");

        stmt.setInt(1, pl.getIdLocal());
        stmt.setString(2, pl.getUsuario());
        stmt.setString(3, pl.getComentario());
        stmt.setString(4, pl.getStatus());
        stmt.setString(5, pl.getData());
        
        boolean retorno = stmt.executeUpdate() > 0;
        
        con.close();
        return retorno;

    }
    
    @Override
    public boolean isMarked(PresencaLocal pl)
            throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select * from presenca_local "
                + "where id_local = ? and usuario = ? and data = ?");

        stmt.setInt(1, pl.getIdLocal());
        stmt.setString(2, pl.getUsuario());
        stmt.setString(3, pl.getData());
        
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
