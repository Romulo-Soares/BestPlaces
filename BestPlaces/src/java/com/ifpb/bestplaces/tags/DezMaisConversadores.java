package com.ifpb.bestplaces.tags;

import com.ifpb.bestplaces.daos.InteracaoUsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DezMaisConversadores extends SimpleTagSupport {

    private String usuarioInteragido;

    @Override
    public void doTag() {
        InteracaoUsuarioDAO iuDAO = new InteracaoUsuarioDAO();

        try {
            getJspContext().setAttribute("dezMaisConversadores", iuDAO.dezMaisConversadores(usuarioInteragido));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DezMaisConversadores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getUsuarioInteragido() {
        return usuarioInteragido;
    }

    public void setUsuarioInteragido(String usuarioInteragido) {
        this.usuarioInteragido = usuarioInteragido;
    }

}
