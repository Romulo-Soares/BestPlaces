
package com.ifpb.bestplaces01.tags;

import com.ifpb.bestplaces01.daos.UsuarioDAO;
import com.ifpb.bestplaces01.entidades.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FindUserProfile extends SimpleTagSupport {
    
    private String email;

    @Override
    public void doTag(){
        
        UsuarioDAO userDAO = new UsuarioDAO();
        try {
            Usuario u = userDAO.read(email);
            getJspContext().setAttribute("usuario", u);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FindUserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
