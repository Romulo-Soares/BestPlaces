package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.EventoDAO;
import com.ifpb.BestPlaces.DAOs.DivulgaEventoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ListaEventosDivulgados extends SimpleTagSupport {

    private String usuario;

    @Override
    public void doTag() {

        DivulgaEventoDAO ged = new DivulgaEventoDAO();
        try {
            getJspContext().setAttribute("eventosDivulgados", ged.eventosDivulgados(usuario));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaEventosDivulgados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
