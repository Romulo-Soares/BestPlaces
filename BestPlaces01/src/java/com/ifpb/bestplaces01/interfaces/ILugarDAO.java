
package com.ifpb.bestplaces01.interfaces;

import com.ifpb.bestplaces01.entidades.Lugar;
import java.sql.SQLException;
import java.util.List;

public interface ILugarDAO {
    
    public Lugar read(int id) throws SQLException, ClassNotFoundException;
    public List<Lugar> list() throws SQLException, ClassNotFoundException;
    public boolean insert(Lugar l) throws SQLException, ClassNotFoundException;
    public boolean delete(int id) throws SQLException, ClassNotFoundException;
    public boolean update(int id, Lugar l) throws SQLException, ClassNotFoundException;
    public boolean lugarExists(int id) throws ClassNotFoundException, SQLException;
    
}
