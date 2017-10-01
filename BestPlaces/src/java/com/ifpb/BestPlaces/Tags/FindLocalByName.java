package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.LocalDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FindLocalByName extends SimpleTagSupport {

    private String nome;

    @Override
    public void doTag() {

        LocalDAO localDAO = new LocalDAO();
        try {
            getJspContext().setAttribute("locais", localDAO.readLocalByName(nome));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FindLocalByName.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
