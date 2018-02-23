package com.ifpb.bestplaces.tags;

import com.ifpb.bestplaces.daos.MensagemDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FindMessages extends SimpleTagSupport {

    private String remetente;
    private String destinatario;

    @Override
    public void doTag() {

        MensagemDAO msgDAO = new MensagemDAO();

        try {
            getJspContext().setAttribute("mensagens", msgDAO.findMessages(remetente, destinatario));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FindMessages.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

}
