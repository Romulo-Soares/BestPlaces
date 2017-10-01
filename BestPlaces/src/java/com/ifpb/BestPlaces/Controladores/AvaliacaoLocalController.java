package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.AvaliacaoLocalDAO;
import com.ifpb.BestPlaces.Entidades.AvaliacaoLocal;
import com.ifpb.BestPlaces.Interfaces.ICommand;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AvaliacaoLocalController implements ICommand {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        HttpSession session = req.getSession();

        String avaliador = (String) session.getAttribute("email");

        int idDoLocal = Integer.parseInt(req.getParameter("idDoLocal"));
        int notaLocal = Integer.parseInt(req.getParameter("fb"));

        AvaliacaoLocalDAO avaliacaoLocalDao = new AvaliacaoLocalDAO();

        if (avaliacaoLocalDao.insert(new AvaliacaoLocal(idDoLocal, avaliador, notaLocal))) {
            res.sendRedirect("pesquisarLocal.jsp");
        }else{
            res.sendRedirect("erro.jsp");
        }

    }

}
