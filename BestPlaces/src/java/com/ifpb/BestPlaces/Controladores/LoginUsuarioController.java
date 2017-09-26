package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.UsuarioDAO;
import com.ifpb.BestPlaces.Entidades.Usuario;
import com.ifpb.BestPlaces.Interfaces.IAutenticavelUsuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifpb.BestPlaces.Interfaces.ICommand;
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
            res.sendRedirect("erroLogin.jsp");
        }

    }

}
