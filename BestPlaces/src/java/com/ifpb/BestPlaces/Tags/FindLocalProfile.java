package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.LocalDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FindLocalProfile extends SimpleTagSupport {

    private String email;
    private String nome;

    @Override
    public void doTag() {

        LocalDAO localDAO = new LocalDAO();
        try {
            getJspContext().setAttribute("local", localDAO.read(email, nome));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FindLocalProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
