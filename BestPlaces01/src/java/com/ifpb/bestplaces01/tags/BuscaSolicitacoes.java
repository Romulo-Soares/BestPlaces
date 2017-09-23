package com.ifpb.bestplaces01.tags;

import com.ifpb.bestplaces01.daos.InteracaoUsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BuscaSolicitacoes extends SimpleTagSupport {

    private String usuarioInteragido;

    @Override
    public void doTag() {

        InteracaoUsuarioDAO iuDAO = new InteracaoUsuarioDAO();
        try {

            getJspContext().setAttribute("solicitacoes", iuDAO.buscaSolicitacoes(usuarioInteragido));

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BuscaSolicitacoes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getUsuarioInteragido() {
        return usuarioInteragido;
    }

    public void setUsuarioInteragido(String usuarioInteragido) {
        this.usuarioInteragido = usuarioInteragido;
    }

}