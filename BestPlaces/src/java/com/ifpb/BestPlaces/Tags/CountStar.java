package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.AvaliacaoLocalDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CountStar extends SimpleTagSupport {

    private int idLocal;

    @Override
    public void doTag() {

        AvaliacaoLocalDAO ald = new AvaliacaoLocalDAO();

        try {
            getJspContext().setAttribute("valorAvaliacao", ald.countStar(idLocal));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CountStar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

}
