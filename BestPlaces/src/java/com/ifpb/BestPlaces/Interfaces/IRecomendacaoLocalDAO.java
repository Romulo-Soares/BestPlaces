package com.ifpb.BestPlaces.Interfaces;

import com.ifpb.BestPlaces.Entidades.Local;
import com.ifpb.BestPlaces.Entidades.RecomendacaoLocal;
import java.sql.SQLException;
import java.util.List;

public interface IRecomendacaoLocalDAO {

    public boolean recomendaLocal(RecomendacaoLocal rl)
            throws SQLException, ClassNotFoundException;

    public boolean isRecommended(RecomendacaoLocal rl)
            throws ClassNotFoundException, SQLException;

    public List<Local> listaLocaisRecomendados(String usuario)
            throws SQLException, ClassNotFoundException;

}
