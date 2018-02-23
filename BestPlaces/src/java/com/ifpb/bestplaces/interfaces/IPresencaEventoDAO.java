package com.ifpb.bestplaces.interfaces;

import com.ifpb.bestplaces.entidades.PostagemPresencaEventos;
import com.ifpb.bestplaces.entidades.PresencaEvento;
import java.sql.SQLException;
import java.util.List;

public interface IPresencaEventoDAO {

    public boolean presenciarEvento(PresencaEvento pe)
            throws SQLException, ClassNotFoundException;

    public boolean isMarked(PresencaEvento pe)
            throws ClassNotFoundException, SQLException;

    public boolean isMarked(int idEvento, String usuario)
            throws ClassNotFoundException, SQLException;
    
    public List<PostagemPresencaEventos> listaEventosPresenciados(String usuario)
            throws SQLException, ClassNotFoundException;

}
