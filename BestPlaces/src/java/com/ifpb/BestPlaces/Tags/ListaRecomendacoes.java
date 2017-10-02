package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.RecomendacaoLocalDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ListaRecomendacoes extends SimpleTagSupport {
    
    private String usuario;
    
    @Override
    public void doTag() {
        
        RecomendacaoLocalDAO rlDAO = new RecomendacaoLocalDAO();
        try {
            getJspContext().setAttribute("recomendacoes", rlDAO.listaLocaisRecomendados(usuario));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaAmigos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
