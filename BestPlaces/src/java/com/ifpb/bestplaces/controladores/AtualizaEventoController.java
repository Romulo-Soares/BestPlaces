package com.ifpb.bestplaces.controladores;

import com.ifpb.bestplaces.daos.EventoDAO;
import com.ifpb.bestplaces.entidades.Evento;
import com.ifpb.bestplaces.interfaces.ICommand;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AtualizaEventoController implements ICommand {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        String data = req.getParameter("data");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(data, formatter);

        if (date.isBefore(LocalDate.now())) {
            res.sendRedirect("erroDataEventoUp.jsp");
        } else {

            Evento e = new Evento();
            e.setNome(req.getParameter("nome"));
            e.setData(req.getParameter("data"));
            e.setHora(req.getParameter("hora"));
            e.setDescricao(req.getParameter("descricao"));
            
            int id = Integer.parseInt(req.getParameter("id"));
           
            EventoDAO eventoDAO = new EventoDAO();
            if (eventoDAO.update(id, e)) {
                res.sendRedirect("evento.jsp");
            } else {
                res.sendRedirect("erro.jsp");
            }
        }

    }

}
