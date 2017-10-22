package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.DivulgaEventoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class VerificaEventoDivulgado extends SimpleTagSupport {

    private int idEvento;
    private String usuario;

    @Override
    public void doTag() {
        try {
            getJspContext().setAttribute("divulgado", new DivulgaEventoDAO().eventoDivulgado(idEvento, usuario));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VerificaEventoDivulgado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
