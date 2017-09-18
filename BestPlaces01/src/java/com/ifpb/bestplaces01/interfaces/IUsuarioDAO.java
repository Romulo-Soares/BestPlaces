
package com.ifpb.bestplaces01.interfaces;

import com.ifpb.bestplaces01.entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDAO {
    
    public Usuario read(String email) throws SQLException, ClassNotFoundException;
    public List<Usuario> list() throws SQLException, ClassNotFoundException;
    public boolean insert(Usuario u) throws SQLException, ClassNotFoundException;
    public boolean delete(String email) throws SQLException, ClassNotFoundException;
    public boolean update(String email, Usuario u) throws SQLException, ClassNotFoundException;
    public boolean userExists(String email) throws ClassNotFoundException, SQLException;
    
}
