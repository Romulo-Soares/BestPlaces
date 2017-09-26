package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.MensagemDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CountUserMensseger extends SimpleTagSupport {

    private String destinatario;

    @Override
    public void doTag() {

        MensagemDAO msgDAO = new MensagemDAO();

        try {
            getJspContext().setAttribute("qntUserMensseger", msgDAO.countUserMensseger(destinatario));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CountUserMensseger.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

}
