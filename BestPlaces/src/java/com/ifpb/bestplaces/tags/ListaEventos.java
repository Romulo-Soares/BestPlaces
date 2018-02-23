package com.ifpb.bestplaces.tags;

import com.ifpb.bestplaces.daos.EventoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ListaEventos extends SimpleTagSupport {

    private String usuarioLogado;

    @Override
    public void doTag() {

        EventoDAO eventoDao = new EventoDAO();
        try {
            getJspContext().setAttribute("eventos", eventoDao.listarEventos(usuarioLogado));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaEventos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
