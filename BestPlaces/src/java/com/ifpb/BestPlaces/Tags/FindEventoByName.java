package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.EventoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FindEventoByName extends SimpleTagSupport {

    private String nome;

    @Override
    public void doTag() {

        EventoDAO eventoDAO = new EventoDAO();
        try {
            getJspContext().setAttribute("eventos", eventoDAO.readEventoByName(nome));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FindEventoByName.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
