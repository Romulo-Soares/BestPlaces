package com.ifpb.BestPlaces.Interfaces;

import com.ifpb.BestPlaces.Entidades.PresencaEvento;
import java.sql.SQLException;

public interface IPresencaEventoDAO {

    public boolean presenciarEvento(PresencaEvento pe)
            throws SQLException, ClassNotFoundException;

    public boolean isMarked(PresencaEvento pe)
            throws ClassNotFoundException, SQLException;

}
