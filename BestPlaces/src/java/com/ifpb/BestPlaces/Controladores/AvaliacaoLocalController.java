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

        AvaliacaoLocalDAO ald = new AvaliacaoLocalDAO();
        AvaliacaoLocal a = new AvaliacaoLocal(idDoLocal, avaliador, notaLocal);

        if (ald.localAvaliado(a)) {
            if (ald.update(a)) {
                if (req.getParameter("avaliarRe") != null) {
                    req.getRequestDispatcher("recomendacoes.jsp?email=" + email + "&nome=" + nome).forward(req, res);
                } else {
                    req.getRequestDispatcher("perfilLocal.jsp?email=" + email + "&nome=" + nome).forward(req, res);
                }
            } else {
                res.sendRedirect("erro.jsp?msg=Nao atualizou");
            }
        } else {
            if (ald.insert(a)) {
                if (req.getParameter("avaliarRe") != null) {
                    req.getRequestDispatcher("recomendacoes.jsp?email=" + email + "&nome=" + nome).forward(req, res);
                } else {
                    req.getRequestDispatcher("perfilLocal.jsp?email=" + email + "&nome=" + nome).forward(req, res);
                }
            } else {
                res.sendRedirect("erro.jsp?msg=Nao inseriu");
            }
        }

    }

}
