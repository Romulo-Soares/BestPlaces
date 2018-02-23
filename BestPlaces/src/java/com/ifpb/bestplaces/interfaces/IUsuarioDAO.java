package com.ifpb.bestplaces.interfaces;

import com.ifpb.bestplaces.entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDAO {

    public Usuario read(String email)
            throws SQLException, ClassNotFoundException;

    public List<Usuario> list()
            throws SQLException, ClassNotFoundException;

    public boolean insert(Usuario u)
            throws SQLException, ClassNotFoundException;

    public boolean delete(String email)
            throws SQLException, ClassNotFoundException;

    public boolean update(String email, Usuario u)
            throws SQLException, ClassNotFoundException;

    public boolean userExists(String email)
            throws ClassNotFoundException, SQLException;

    public List<Usuario> readUserByName(String nome, String emailExcecao)
            throws SQLException, ClassNotFoundException;

}
