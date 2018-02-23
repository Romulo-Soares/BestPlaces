package com.ifpb.bestplaces.controladores;

import com.ifpb.bestplaces.daos.MensagemDAO;
import com.ifpb.bestplaces.entidades.Mensagem;
import com.ifpb.bestplaces.interfaces.ICommand;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MensagemController implements ICommand {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        HttpSession session = req.getSession();

        String remetente = (String) session.getAttribute("email");
        String destinatario = req.getParameter("destinatario");
        String mensagem = req.getParameter("mensagem");

        MensagemDAO mDAO = new MensagemDAO();
        Mensagem m = new Mensagem(remetente, destinatario, mensagem);

        if (req.getParameter("enviarMensagem") != null) {
            if (mDAO.insert(m)) {
                res.sendRedirect("amigos.jsp");
            }
        }
        if (req.getParameter("respostaMensagem") != null) {
            if (mDAO.insert(m)) {
                res.sendRedirect("mensagem.jsp");
            }
        }
        if (req.getParameter("enviarMensagemI") != null) {
            if (mDAO.insert(m)) {
                res.sendRedirect("inicial.jsp");
            }
        }
    }

}
