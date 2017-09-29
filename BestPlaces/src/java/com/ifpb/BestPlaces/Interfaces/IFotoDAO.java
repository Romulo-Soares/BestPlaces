
package com.ifpb.BestPlaces.Interfaces;

import com.ifpb.BestPlaces.Entidades.Foto;
import java.sql.SQLException;
import java.util.List;

public interface IFotoDAO {
    
    public Foto read(int id, String tabela) 
            throws SQLException, ClassNotFoundException;
    public boolean insert(Foto f, String tabela) 
            throws SQLException, ClassNotFoundException;
    public boolean delete(int id, String tabela) 
            throws SQLException, ClassNotFoundException;
    public List<Foto> listarFotosLocal(int idLocal)
            throws SQLException, ClassNotFoundException;
}
