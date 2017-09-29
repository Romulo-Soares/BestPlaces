package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.LocalDAO;
import com.ifpb.BestPlaces.Entidades.Local;
import com.ifpb.BestPlaces.Interfaces.ICommand;
import com.ifpb.BestPlaces.Interfaces.IFileManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CadastraLocalController implements ICommand, IFileManager {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {

        HttpSession session = req.getSession();

        LocalDAO localDAO = new LocalDAO();

        Local l = new Local();

        if (localDAO.localExists((String) session.getAttribute("email"), req.getParameter("nome"))) {
            res.sendRedirect("erro.jsp");
        } else {

            l.setUsuario((String) session.getAttribute("email"));
            l.setNome(req.getParameter("nome"));
            l.setRua(req.getParameter("rua"));
            l.setCidade(req.getParameter("cidade"));
            l.setDescricao(req.getParameter("descricao"));
            l.setEstado(req.getParameter("estado"));
            l.setTipo(req.getParameter("tipo"));

            if (localDAO.insert(l)) {
                res.sendRedirect("local.jsp");
            } else {
                res.sendRedirect("erro.jsp");
            }
        }
    }

}
