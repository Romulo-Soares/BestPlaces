package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.FotoDAO;
import com.ifpb.BestPlaces.DAOs.PresencaLocalDAO;
import com.ifpb.BestPlaces.Entidades.Foto;
import com.ifpb.BestPlaces.Entidades.PresencaLocal;
import com.ifpb.BestPlaces.Interfaces.ICommand;
import com.ifpb.BestPlaces.Interfaces.IFileManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PresencaLocalController implements ICommand, IFileManager {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        HttpSession session = req.getSession();
        
        String usuario = (String) session.getAttribute("email");
        int id_local = Integer.parseInt(req.getParameter("id_local"));
        String comentario = req.getParameter("comentario");
        String status = req.getParameter("status");
        String data = req.getParameter("data");

        String nomeLocal = req.getParameter("nomeLocal");
        
        FotoDAO ftDAO = new FotoDAO();
        
        String foto = uploadFile("fotosPresencaLocal/" + nomeLocal, req,
                req.getPart("foto"), nomeLocal + ftDAO.interatorFotos_Local("fotos_presenca_local"));

        PresencaLocal pl = new PresencaLocal(id_local, usuario, comentario, status, data);
        Foto f = new Foto(id_local, foto);

        PresencaLocalDAO plDAO = new PresencaLocalDAO();
        FotoDAO fDAO = new FotoDAO();

        if (req.getParameter("btMarcaPresencaRecomendacoes") != null) {

            if (!plDAO.isMarked(pl)) {
                if (plDAO.presenciarLocal(pl) && fDAO.insert(f, "Fotos_Presenca_Local")) {
                    res.sendRedirect("recomendacoes.jsp?email=" + usuario + "&nome=" + nomeLocal);
                } else {
                    res.sendRedirect("erro.jsp");
                }
            } else {
                res.sendRedirect("recomendacoes.jsp?email=" + usuario
                        + "&nome=" + nomeLocal + "&isMarked=true");
            }

        } else {

            if (!plDAO.isMarked(pl)) {
                if (plDAO.presenciarLocal(pl) && fDAO.insert(f, "Fotos_Presenca_Local")) {
                    res.sendRedirect("perfilLocal.jsp?email=" + usuario + "&nome=" + nomeLocal);
                } else {
                    res.sendRedirect("erro.jsp");
                }
            } else {
                res.sendRedirect("perfilLocal.jsp?email=" + usuario
                        + "&nome=" + nomeLocal + "&isMarked=true");
            }
        }

    }

}
