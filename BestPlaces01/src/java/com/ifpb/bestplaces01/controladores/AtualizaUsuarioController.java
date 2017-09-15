package com.ifpb.bestplaces01.controladores;

import com.ifpb.bestplaces01.daos.UsuarioDAO;
import com.ifpb.bestplaces01.entidades.Usuario;
import com.ifpb.bestplaces01.interfaces.ICommand;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AtualizaUsuarioController implements ICommand {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        HttpSession session = req.getSession();
        String emailLogado = (String) session.getAttribute("email");

        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String cidade = req.getParameter("cidade");
        String sexo = req.getParameter("sexo");
        String profissao = req.getParameter("profissao");
        String nascimento = req.getParameter("nascimento");
        String senha = req.getParameter("senha");
        String foto = req.getParameter("fotoPerfil");

        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setCidade(cidade);
        u.setFotoPerfil(foto);
        u.setProfissao(profissao);
        u.setSenha(senha);
        u.setSexo(sexo);
        u.setNascimento(nascimento);

        UsuarioDAO userDAO = new UsuarioDAO();
        if (userDAO.update(emailLogado, u)) {
            session.setAttribute("email", email);
            session.setAttribute("senha", senha);
            session.setAttribute("nome", nome);
            session.setAttribute("foto", foto);
            session.setAttribute("cidade", cidade);
            session.setAttribute("profissao", profissao);
            session.setAttribute("sexo", sexo);
            session.setAttribute("nascimento", nascimento);

            req.getRequestDispatcher("inicial.jsp").forward(req, res);
        }

    }

}
