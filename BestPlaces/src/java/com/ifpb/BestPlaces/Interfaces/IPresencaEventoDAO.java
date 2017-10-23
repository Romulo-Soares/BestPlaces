package com.ifpb.BestPlaces.Interfaces;

import com.ifpb.BestPlaces.Entidades.PostagemPresencaEventos;
import com.ifpb.BestPlaces.Entidades.PresencaEvento;
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
