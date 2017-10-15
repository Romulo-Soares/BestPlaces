package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.EventoDAO;
import com.ifpb.BestPlaces.Entidades.Evento;
import com.ifpb.BestPlaces.Interfaces.ICommand;
import com.ifpb.BestPlaces.Interfaces.IFileManager;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CadastraEventoController implements ICommand, IFileManager {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {

        HttpSession session = req.getSession();

        EventoDAO eventoDAO = new EventoDAO();

        Evento e = new Evento();

        if (eventoDAO.eventoExists((String) session.getAttribute("email"), req.getParameter("nome"))) {
            res.sendRedirect("erro.jsp");
        } else {

            String data = req.getParameter("data");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(data, formatter);

            if (date.isBefore(LocalDate.now())) {
                res.sendRedirect("erroDataEvento.jsp");
            } else {
                e.setUsuario((String) session.getAttribute("email"));
                e.setIdLocal(Integer.parseInt(req.getParameter("idLocal")));
                e.setNome(req.getParameter("nome"));
                e.setData(req.getParameter("data"));
                e.setHora(req.getParameter("hora"));
                e.setLocal(req.getParameter("local"));
                e.setDescricao(req.getParameter("descricao"));
            }
            if (eventoDAO.insert(e)) {
                res.sendRedirect("evento.jsp");
            } else {
                res.sendRedirect("erro.jsp");
            }
        }
    }

}
