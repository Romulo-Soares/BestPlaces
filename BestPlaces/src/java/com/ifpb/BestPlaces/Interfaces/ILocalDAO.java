
package com.ifpb.BestPlaces.Interfaces;

import com.ifpb.BestPlaces.Entidades.Local;
import java.sql.SQLException;
import java.util.List;

public interface ILocalDAO {
    
    public Local read(String usuario, String nome) 
            throws SQLException, ClassNotFoundException;
    public List<Local> list() 
            throws SQLException, ClassNotFoundException;
    public boolean insert(Local l) 
            throws SQLException, ClassNotFoundException;
    public boolean delete(int id) 
            throws SQLException, ClassNotFoundException;
    public boolean update(int id, Local l) 
            throws SQLException, ClassNotFoundException;
    public boolean localExists(String usuario, String nome) 
            throws ClassNotFoundException, SQLException;
    public List<Local> listarLocais(String usuarioLogado) 
            throws ClassNotFoundException, SQLException;
}
