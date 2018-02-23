package com.ifpb.bestplaces.controladores;

import com.ifpb.bestplaces.daos.InteracaoUsuarioDAO;
import com.ifpb.bestplaces.interfaces.ICommand;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GerenciaInteracaoController implements ICommand {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        HttpSession session = req.getSession();
        String usuarioInteraginte = (String) session.getAttribute("email");

        String usuarioInteragido = req.getParameter("usuarioInteragido");

        InteracaoUsuarioDAO iuDAO = new InteracaoUsuarioDAO();

        if (req.getParameter("fazerSolicitacao") != null) {
            if (!iuDAO.isUpgradeable(usuarioInteraginte, usuarioInteragido)) {
                if (iuDAO.enviarSolicitacaoAmizade(usuarioInteraginte, usuarioInteragido)) {
                    res.sendRedirect("perfil.jsp?email=" + usuarioInteragido);
                }
            } else {
                if (iuDAO.gerenciarInteracao(usuarioInteraginte, usuarioInteragido, false, true)) {
                    res.sendRedirect("perfil.jsp?email=" + usuarioInteragido);
                }
            }
        } else if (req.getParameter("desfazerSolicitacao") != null) {
            if (iuDAO.gerenciarInteracao(usuarioInteraginte, usuarioInteragido, false, false)) {
                res.sendRedirect("perfil.jsp?email=" + usuarioInteragido);
            }
        } else if (req.getParameter("aceitarConvite") != null) {
            if (iuDAO.gerenciarInteracao(usuarioInteragido, usuarioInteraginte, true, false)) {
                res.sendRedirect("solicitacao.jsp");          
            }
        }else if (req.getParameter("rejeitarConvite") != null){ 
            if (iuDAO.gerenciarInteracao(usuarioInteragido, usuarioInteraginte, false, false)) {
                res.sendRedirect("solicitacao.jsp");
            }   
        }else if (req.getParameter("desfazerAmizade") != null){
            if (iuDAO.gerenciarInteracao(usuarioInteragido, usuarioInteraginte, false, false)) {
                res.sendRedirect("amigos.jsp");
            }else if (iuDAO.gerenciarInteracao(usuarioInteraginte, usuarioInteragido, false, false)) {
                res.sendRedirect("amigos.jsp");
            }
        }

    }
}
