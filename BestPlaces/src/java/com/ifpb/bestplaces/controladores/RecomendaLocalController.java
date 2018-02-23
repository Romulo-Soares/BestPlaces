package com.ifpb.bestplaces.controladores;

import com.ifpb.bestplaces.daos.RecomendacaoLocalDAO;
import com.ifpb.bestplaces.entidades.RecomendacaoLocal;
import com.ifpb.bestplaces.interfaces.ICommand;
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

        String usuario_recomendador = req.getParameter("email");
        String usuario_destino = req.getParameter("usuario_destino");
        int id_local = Integer.parseInt(req.getParameter("id_local"));
        String nomeLocal = req.getParameter("nomeLocal");

        RecomendacaoLocalDAO rlDAO = new RecomendacaoLocalDAO();
        RecomendacaoLocal rl = new RecomendacaoLocal(usuario_recomendador, usuario_destino, id_local);
        
        String back = "perfilLocal.jsp";
        
        if (!rlDAO.isRecommended(rl)) {
            if (rlDAO.recomendaLocal(rl)) {
               if(req.getParameter("recomendarPageLocal") != null){
                   res.sendRedirect("local.jsp?email=" + usuario_recomendador
                    + "&nome=" + nomeLocal);
               }else{
                   res.sendRedirect("perfilLocal.jsp?email=" + usuario_recomendador
                    + "&nome=" + nomeLocal);
               } 
            } else {
                if(req.getParameter("recomendarPageLocal") != null) back = "local.jsp";
                res.sendRedirect("erro.jsp?email=" + usuario_recomendador
                    + "&nome=" + nomeLocal + "&back=" + "&msg=O "
                            + "usuario nao eh amigo do recomendado");
            }
        } else {
            if(req.getParameter("recomendarPageLocal") != null){
                res.sendRedirect("local.jsp?email=" + usuario_recomendador
                    + "&nome=" + nomeLocal + "&isRecommended=true");
            }else{
                res.sendRedirect("perfilLocal.jsp?email=" + usuario_recomendador
                    + "&nome=" + nomeLocal + "&isRecommended=true");
            }
            
        }

    }

}
