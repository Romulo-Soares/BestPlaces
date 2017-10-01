
package com.ifpb.BestPlaces.Interfaces;

import com.ifpb.BestPlaces.Entidades.AvaliacaoLocal;
import java.sql.SQLException;

public interface IAvaliacaoLocal {
    
    public boolean insert(AvaliacaoLocal a)
            throws SQLException, ClassNotFoundException;
    
}
