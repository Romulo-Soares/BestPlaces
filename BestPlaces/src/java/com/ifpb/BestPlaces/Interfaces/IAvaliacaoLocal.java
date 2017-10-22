package com.ifpb.BestPlaces.Interfaces;

import com.ifpb.BestPlaces.Entidades.AvaliacaoLocal;
import java.sql.SQLException;

public interface IAvaliacaoLocal {

    public boolean insert(AvaliacaoLocal a)
            throws SQLException, ClassNotFoundException;

    public int countStar(int idLocal)
            throws SQLException, ClassNotFoundException;

    public boolean localAvaliado(AvaliacaoLocal a)
            throws ClassNotFoundException, SQLException;

    public boolean update(AvaliacaoLocal a)
            throws SQLException, ClassNotFoundException;
}
