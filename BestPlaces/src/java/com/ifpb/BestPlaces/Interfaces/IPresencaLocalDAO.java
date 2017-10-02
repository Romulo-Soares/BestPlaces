package com.ifpb.BestPlaces.Interfaces;

import com.ifpb.BestPlaces.Entidades.PresencaLocal;
import java.sql.SQLException;

public interface IPresencaLocalDAO {

    public boolean presenciarLocal(PresencaLocal pl)
            throws SQLException, ClassNotFoundException;

    public boolean isMarked(PresencaLocal pl)
            throws ClassNotFoundException, SQLException;
}
