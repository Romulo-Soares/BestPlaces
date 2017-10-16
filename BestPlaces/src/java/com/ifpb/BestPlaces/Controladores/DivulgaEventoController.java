package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.DivulgaEventoDAO;
import com.ifpb.BestPlaces.Interfaces.ICommand;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DivulgaEventoController implements ICommand {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        HttpSession session = req.getSession();
        String usuario = (String) session.getAttribute("email");

        int idEvento = Integer.parseInt(req.getParameter("idEvento"));

        DivulgaEventoDAO ged = new DivulgaEventoDAO();

        if (req.getParameter("divulgar") != null) {
            if (ged.insert(idEvento, usuario)) {
                res.sendRedirect("perfilEvento.jsp?idEvento=" + idEvento
                        + "&divulgado=true");
            } else {
                res.sendRedirect("perfilEvento.jsp?idEvento=" + idEvento
                        + "&divulgado=false");
            }
        } else if (req.getParameter("desfazerDivulgacao") != null) {
            if (ged.delete(idEvento)) {
                res.sendRedirect("perfilEvento.jsp?idEvento=" + idEvento
                        + "&divulgado=false");
            } else {
                res.sendRedirect("perfilEvento.jsp?idEvento=" + idEvento
                        + "&divulgado=true");
            }
        }
    }
}
