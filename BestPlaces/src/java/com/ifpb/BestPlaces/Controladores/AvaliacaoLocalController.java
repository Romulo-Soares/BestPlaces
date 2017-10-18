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
        String email = req.getParameter("email");
        String nome = req.getParameter("nome");

        AvaliacaoLocalDAO avaliacaoLocalDao = new AvaliacaoLocalDAO();

        if (req.getParameter("avaliar") != null) {
            if (avaliacaoLocalDao.insert(new AvaliacaoLocal(idDoLocal, avaliador, notaLocal))) {
                req.getRequestDispatcher("perfilLocal.jsp?email=" + email + "&nome=" + nome).forward(req, res);
            } else {
                res.sendRedirect("erro.jsp");
            }
        } else {
            if (avaliacaoLocalDao.update(new AvaliacaoLocal(idDoLocal, avaliador, notaLocal))) {
                req.getRequestDispatcher("perfilLocal.jsp?email=" + email + "&nome=" + nome).forward(req, res);
            } else {
                res.sendRedirect("erro.jsp");
            }
        }

    }

}
