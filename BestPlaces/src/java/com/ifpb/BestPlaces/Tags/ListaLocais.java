package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.LocalDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ListaLocais extends SimpleTagSupport {

    private String usuarioLogado;

    @Override
    public void doTag() {

        LocalDAO localDao = new LocalDAO();
        try {
            getJspContext().setAttribute("locais", localDao.listarLocais(usuarioLogado));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaLocais.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
