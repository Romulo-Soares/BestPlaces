
package com.ifpb.bestplaces.tags;

import com.ifpb.bestplaces.daos.MensagemDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FindUserMensseger extends SimpleTagSupport {
    
    private String destinatario;
    
    @Override
    public void doTag(){
        MensagemDAO msgDAO = new MensagemDAO();
        try {
            getJspContext().setAttribute("mensageiros", msgDAO.findUserMessenger(destinatario));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FindUserMensseger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

}
