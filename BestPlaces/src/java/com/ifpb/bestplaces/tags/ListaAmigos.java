package com.ifpb.bestplaces.tags;

import com.ifpb.bestplaces.daos.InteracaoUsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ListaAmigos extends SimpleTagSupport {

    private String usuarioInteragido;

    @Override
    public void doTag() {

        InteracaoUsuarioDAO iuDAO = new InteracaoUsuarioDAO();
        try {
            getJspContext().setAttribute("amigos", iuDAO.listarAmigos(usuarioInteragido));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaAmigos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getUsuarioInteragido() {
        return usuarioInteragido;
    }

    public void setUsuarioInteragido(String usuarioInteragido) {
        this.usuarioInteragido = usuarioInteragido;
    }

}
