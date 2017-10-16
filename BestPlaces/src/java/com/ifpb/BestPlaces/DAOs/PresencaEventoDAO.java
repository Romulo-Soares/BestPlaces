package com.ifpb.BestPlaces.DAOs;

import com.ifpb.BestPlaces.Conexao.ConFactory;
import com.ifpb.BestPlaces.Entidades.PresencaEvento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PresencaEventoDAO {

    public boolean presenciarEvento(PresencaEvento pe)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO Presenca_Evento (ID_Evento, Usuario, "
                + "Comentario, Status, Data) VALUES (?,?,?,?,?)");

        stmt.setInt(1, pe.getIdEvento());
        stmt.setString(2, pe.getUsuario());
        stmt.setString(3, pe.getComentario());
        stmt.setString(4, pe.getStatus());
        stmt.setString(5, pe.getData());

        boolean retorno = stmt.executeUpdate() > 0;

        con.close();
        return retorno;

    }

}
