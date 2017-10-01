package com.ifpb.BestPlaces.DAOs;

import com.ifpb.BestPlaces.Conexao.ConFactory;
import com.ifpb.BestPlaces.Entidades.AvaliacaoLocal;
import com.ifpb.BestPlaces.Interfaces.IAvaliacaoLocal;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
