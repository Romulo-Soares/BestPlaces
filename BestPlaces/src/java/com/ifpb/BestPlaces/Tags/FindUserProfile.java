package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FindUserProfile extends SimpleTagSupport {

    private String email;

    @Override
    public void doTag() {

        UsuarioDAO userDAO = new UsuarioDAO();
        try {
            getJspContext().setAttribute("usuario", userDAO.read(email));
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
