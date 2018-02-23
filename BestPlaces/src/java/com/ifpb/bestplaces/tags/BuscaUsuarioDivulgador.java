package com.ifpb.bestplaces.tags;

import com.ifpb.bestplaces.daos.DivulgaEventoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BuscaUsuarioDivulgador extends SimpleTagSupport {
    
    private int idEvento;

    @Override
    public void doTag() {

        try {
            getJspContext().setAttribute("usuarioDivulgador", new DivulgaEventoDAO().getNomeUsuarioDivulgador(idEvento));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BuscaUsuarioDivulgador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

}
