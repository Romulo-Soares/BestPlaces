package com.ifpb.bestplaces.tags;

import com.ifpb.bestplaces.daos.EventoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FindEventoProfile extends SimpleTagSupport {

    private int idEvento;

    @Override
    public void doTag() {

        EventoDAO eventoDAO = new EventoDAO();
        try {
            getJspContext().setAttribute("evento", eventoDAO.read(idEvento));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FindEventoProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

}
