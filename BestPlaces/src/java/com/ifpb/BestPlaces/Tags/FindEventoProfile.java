package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.EventoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FindEventoProfile extends SimpleTagSupport {

    private String email;
    private String nome;

    @Override
    public void doTag() {

        EventoDAO eventoDAO = new EventoDAO();
        try {
            getJspContext().setAttribute("evento", eventoDAO.read(email, nome));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FindEventoProfile.class.getName()).log(Level.SEVERE, null, ex);
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
