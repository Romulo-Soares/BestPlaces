package com.ifpb.BestPlaces.Interfaces;

import com.ifpb.BestPlaces.Entidades.Local;
import com.ifpb.BestPlaces.Entidades.PostagemPresencaLocais;
import com.ifpb.BestPlaces.Entidades.PresencaLocal;
import java.sql.SQLException;
import java.util.List;

public interface IPresencaLocalDAO {

    public boolean presenciarLocal(PresencaLocal pl)
            throws SQLException, ClassNotFoundException;

    public boolean isMarked(PresencaLocal pl)
            throws ClassNotFoundException, SQLException;

    public boolean isMarked(int idLocal, String usuario)
            throws ClassNotFoundException, SQLException;
    
    public List<PostagemPresencaLocais> listaLocaisPresenciados(String usuario)
            throws SQLException, ClassNotFoundException;
}
