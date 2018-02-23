package com.ifpb.bestplaces.controladores;

import com.ifpb.bestplaces.daos.FotoDAO;
import com.ifpb.bestplaces.entidades.Foto;
import com.ifpb.bestplaces.interfaces.ICommand;
import com.ifpb.bestplaces.interfaces.IFileManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaFotoPresencaEventoController implements ICommand, IFileManager {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {

        FotoDAO fotoDAO = new FotoDAO();

        Foto f = new Foto();
        int id = Integer.parseInt(req.getParameter("id"));
        f.setId(id);

        String foto = uploadFile("fotosPresencaEvento/" + req.getParameter("fotoPresencaEvento"), req,
                req.getPart("fotoPresencaEvento"), req.getParameter("fotoPresencaEvento") + fotoDAO.interatorFotos_Local("fotos_presenca_evento"));
        f.setFoto(foto);

        if (fotoDAO.insertE(f, "fotos_presenca_evento")) {
            if (req.getParameter("adicionarFotoPerfil") != null) {
                res.sendRedirect("perfilEvento.jsp?idEvento=" + id);
            } else {
                res.sendRedirect("evento.jsp");
            }
        } else {
            res.sendRedirect("erro.jsp");
        }
    }

}
