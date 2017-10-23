package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.PresencaLocalDAO;
import com.ifpb.BestPlaces.DAOs.RecomendacaoLocalDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BuscaUsuarioRecomendador extends SimpleTagSupport {
    
    private String usuarioDestino;
    private int idLocal;

    @Override
    public void doTag() {

        try {
            getJspContext().setAttribute("usuarioRecomendador", new RecomendacaoLocalDAO().getNomeUsuarioRecomendador(usuarioDestino, idLocal));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BuscaUsuarioRecomendador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(String usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }

}
