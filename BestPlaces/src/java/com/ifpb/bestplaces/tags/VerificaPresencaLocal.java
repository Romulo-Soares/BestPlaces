package com.ifpb.bestplaces.tags;

import com.ifpb.bestplaces.daos.PresencaLocalDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class VerificaPresencaLocal extends SimpleTagSupport {

    private int idLocal;
    private String usuario;

    @Override
    public void doTag() {

        try {
            getJspContext().setAttribute("presenciado", new PresencaLocalDAO().isMarked(idLocal, usuario));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VerificaPresencaLocal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
