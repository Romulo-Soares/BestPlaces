package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.RecomendacaoLocalDAO;
import com.ifpb.BestPlaces.Entidades.RecomendacaoLocal;
import com.ifpb.BestPlaces.Interfaces.ICommand;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RecomendaLocalController implements ICommand {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        HttpSession session = req.getSession();

        String usuario_recomendador = (String) session.getAttribute("email");
        String usuario_destino = req.getParameter("usuario_destino");
        int id_local = Integer.parseInt(req.getParameter("id_local"));
        String nomeLocal = req.getParameter("nomeLocal");

        RecomendacaoLocalDAO rlDAO = new RecomendacaoLocalDAO();
        RecomendacaoLocal rl = new RecomendacaoLocal(usuario_recomendador, usuario_destino, id_local);

        if (!rlDAO.isRecommended(rl)) {
            if (rlDAO.recomendaLocal(rl)) {
                req.setAttribute("email", usuario_recomendador);
                req.setAttribute("nome", nomeLocal);
                req.getRequestDispatcher("perfilLocal.jsp").forward(req, res);
            } else {
                req.setAttribute("email", usuario_recomendador);
                req.setAttribute("nome", nomeLocal);
                req.setAttribute("back", "perfilLocal.jsp");
                req.setAttribute("msg", "O Usuario não é amigo do recomendado!");
                req.getRequestDispatcher("erro.jsp").forward(req, res);
            }
        } else {
            res.sendRedirect("perfilLocal.jsp?email=" + usuario_recomendador
                    + "&nome=" + nomeLocal + "&isRecommended=true");
        }

    }

}
