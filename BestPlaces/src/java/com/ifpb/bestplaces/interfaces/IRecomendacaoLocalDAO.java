package com.ifpb.bestplaces.interfaces;

import com.ifpb.bestplaces.entidades.Local;
import com.ifpb.bestplaces.entidades.RecomendacaoLocal;
import java.sql.SQLException;
import java.util.List;

public interface IRecomendacaoLocalDAO {

    public boolean recomendaLocal(RecomendacaoLocal rl)
            throws SQLException, ClassNotFoundException;

    public boolean isRecommended(RecomendacaoLocal rl)
            throws ClassNotFoundException, SQLException;

    public List<Local> listaLocaisRecomendados(String usuario)
            throws SQLException, ClassNotFoundException;

    public String getNomeUsuarioRecomendador(String usuarioDestino, int idLocal)
            throws SQLException, ClassNotFoundException;

}
