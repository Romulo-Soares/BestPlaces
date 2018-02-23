package com.ifpb.bestplaces.interfaces;

import com.ifpb.bestplaces.entidades.Evento;
import java.sql.SQLException;
import java.util.List;

public interface IEventoDAO {

    public Evento read(int idEvento)
            throws SQLException, ClassNotFoundException;

    public List<Evento> readEventoByName(String nome)
            throws SQLException, ClassNotFoundException;

    public List<Evento> list()
            throws SQLException, ClassNotFoundException;

    public boolean insert(Evento e)
            throws SQLException, ClassNotFoundException;

    public boolean delete(int id)
            throws SQLException, ClassNotFoundException;

    public boolean update(int id, Evento e)
            throws SQLException, ClassNotFoundException;

    public boolean eventoExists(String usuario, String nome)
            throws ClassNotFoundException, SQLException;

    public List<Evento> listarEventos(String usuarioLogado)
            throws ClassNotFoundException, SQLException;
}
