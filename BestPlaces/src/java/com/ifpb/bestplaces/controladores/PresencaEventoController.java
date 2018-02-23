package com.ifpb.bestplaces.controladores;

import com.ifpb.bestplaces.daos.FotoDAO;
import com.ifpb.bestplaces.daos.DivulgaEventoDAO;
import com.ifpb.bestplaces.daos.PresencaEventoDAO;
import com.ifpb.bestplaces.entidades.Foto;
import com.ifpb.bestplaces.entidades.PresencaEvento;
import com.ifpb.bestplaces.interfaces.ICommand;
import com.ifpb.bestplaces.interfaces.IFileManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PresencaEventoController implements ICommand, IFileManager {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        HttpSession session = req.getSession();

        String nome = req.getParameter("nome");
        int idEvento = Integer.parseInt(req.getParameter("idEvento"));

        PresencaEvento pe = new PresencaEvento();
        pe.setComentario(req.getParameter("comentario"));
        pe.setData(req.getParameter("data"));
        pe.setIdEvento(idEvento);
        pe.setStatus(req.getParameter("status"));
        pe.setUsuario((String) session.getAttribute("email"));

        FotoDAO ftDAO = new FotoDAO();
        PresencaEventoDAO peDAO = new PresencaEventoDAO();

        String foto = uploadFile("fotosPresencaEvento/" + nome, req,
                req.getPart("foto"), nome + ftDAO.interatorFotos_Local("Fotos_Presenca_Evento"));

        Foto ft = new Foto(idEvento, foto);

        if (!peDAO.isMarked(pe)) {
            if (peDAO.presenciarEvento(pe) && ftDAO.insertFotosPresencaEvento(ft, "Fotos_Presenca_Evento")) {
                if(req.getParameter("mpE") != null){
                    res.sendRedirect("evento.jsp?idEvento=" + idEvento);
                }else{
                    res.sendRedirect("perfilEvento.jsp?idEvento=" + idEvento);
                }
            } else {
                res.sendRedirect("erro.jsp");
            }
        } else {
            if(req.getParameter("mpE") != null){
                res.sendRedirect("evento.jsp?idEvento=" + idEvento + "&isMarked=true");
            }else{
                res.sendRedirect("perfilEvento.jsp?idEvento=" + idEvento + "&isMarked=true");
            }
        }
    }
}
