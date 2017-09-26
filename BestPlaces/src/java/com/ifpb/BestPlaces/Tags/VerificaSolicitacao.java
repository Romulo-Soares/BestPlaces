package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.InteracaoUsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class VerificaSolicitacao extends SimpleTagSupport {

    private String usuarioInteraginte;
    private String usuarioInteragido;

    @Override
    public void doTag() {

        InteracaoUsuarioDAO iuDAO = new InteracaoUsuarioDAO();
        try {
            if (iuDAO.isRequested(usuarioInteraginte, usuarioInteragido)) {
                getJspContext().setAttribute("solicitado", true);
            } else {
                if (iuDAO.isFriend(usuarioInteraginte, usuarioInteragido)) {
                    getJspContext().setAttribute("amigo", true);
                } else {
                    getJspContext().setAttribute("amigo", false);
                }
                getJspContext().setAttribute("solicitado", false);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VerificaSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getUsuarioInteraginte() {
        return usuarioInteraginte;
    }

    public void setUsuarioInteraginte(String usuarioInteraginte) {
        this.usuarioInteraginte = usuarioInteraginte;
    }

    public String getUsuarioInteragido() {
        return usuarioInteragido;
    }

    public void setUsuarioInteragido(String usuarioInteragido) {
        this.usuarioInteragido = usuarioInteragido;
    }

}
