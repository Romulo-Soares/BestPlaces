package com.ifpb.BestPlaces.Tags;

import com.ifpb.BestPlaces.DAOs.FotoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RetornaFotoLocal extends SimpleTagSupport {

    private int idLocal;

    @Override
    public void doTag() {

        FotoDAO fotoDao = new FotoDAO();
        try {
            getJspContext().setAttribute("fotoLocal", fotoDao.retornaFotoLocal(idLocal));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RetornaFotoLocal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

}
