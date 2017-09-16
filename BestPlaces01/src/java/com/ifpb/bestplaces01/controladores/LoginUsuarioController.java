package com.ifpb.bestplaces01.controladores;

import com.ifpb.bestplaces01.daos.UsuarioDAO;
import com.ifpb.bestplaces01.entidades.Usuario;
import com.ifpb.bestplaces01.interfaces.IAutenticavelUsuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifpb.bestplaces01.interfaces.ICommand;
import javax.servlet.http.HttpSession;

public class LoginUsuarioController implements ICommand, IAutenticavelUsuario {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        if (autenticarUsuario(email, senha)) {

            UsuarioDAO userDAO = new UsuarioDAO();

            Usuario u = userDAO.read(email);

            HttpSession session = req.getSession();
            session.setAttribute("nome", u.getNome());
            session.setAttribute("cidade", u.getCidade());
            session.setAttribute("email", u.getEmail());
            session.setAttribute("foto", u.getFotoPerfil());
            session.setAttribute("nascimento", u.getNascimento());
            session.setAttribute("profissao", u.getProfissao());
            session.setAttribute("senha", u.getSenha());
            session.setAttribute("sexo", u.getSexo());

            req.getRequestDispatcher("inicial.jsp").forward(req, res);
            
        } else {
            res.sendRedirect("index.jsp");
        }

    }

}
