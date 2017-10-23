package com.ifpb.BestPlaces.Interfaces;

import com.ifpb.BestPlaces.Entidades.Evento;
import java.sql.SQLException;
import java.util.List;

public interface IDivulgaEventoDAO {

    public boolean insert(int idEvento, String usuario)
            throws SQLException, ClassNotFoundException;

    public boolean delete(int idEvento)
            throws SQLException, ClassNotFoundException;

    public List<Evento> eventosDivulgados(String usuario)
            throws SQLException, ClassNotFoundException;

    public boolean eventoDivulgado(int idEvento, String usuario)
            throws ClassNotFoundException, SQLException;

    public String getNomeUsuarioDivulgador(int idEvento)
            throws SQLException, ClassNotFoundException;

}
