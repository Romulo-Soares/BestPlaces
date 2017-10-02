package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.MensagemDAO;
import com.ifpb.BestPlaces.DAOs.RecomendacaoLocalDAO;
import com.ifpb.BestPlaces.Entidades.AvaliacaoLocal;
import com.ifpb.BestPlaces.Entidades.Mensagem;
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
                res.sendRedirect("perfilLocal.jsp?email=" + usuario_recomendador + "&nome=" + nomeLocal);
            } else {
                res.sendRedirect("erro.jsp");
            }
        } else {
            res.sendRedirect("perfilLocal.jsp?email=" + usuario_recomendador 
                    + "&nome=" + nomeLocal + "&isRecommended=true");
        }

    }

}
