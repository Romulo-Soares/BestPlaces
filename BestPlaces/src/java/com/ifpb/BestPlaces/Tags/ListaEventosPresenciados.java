package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.PresencaEventoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ListaEventosPresenciados extends SimpleTagSupport {
    
    private String usuario;
    
    @Override
    public void doTag() {
        
        try {
            getJspContext().setAttribute("eventosPresenciados", new PresencaEventoDAO().listaEventosPresenciados(usuario));
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
