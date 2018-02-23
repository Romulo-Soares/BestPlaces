package com.ifpb.bestplaces.tags;

import com.ifpb.bestplaces.daos.FotoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ListaFotosLocal extends SimpleTagSupport {

    private int idFoto;

    @Override
    public void doTag() {

        FotoDAO fotoDao = new FotoDAO();
        try {
            getJspContext().setAttribute("fotosLocal", fotoDao.listarFotosLocal(idFoto));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaFotosLocal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

}
