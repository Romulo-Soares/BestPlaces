package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.PresencaLocalDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ListaLocaisPresenciados extends SimpleTagSupport {
    
    private String usuario;
    
    @Override
    public void doTag() {
        
        try {
            getJspContext().setAttribute("locaisPresenciados", new PresencaLocalDAO().listaLocaisPresenciados(usuario));
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
