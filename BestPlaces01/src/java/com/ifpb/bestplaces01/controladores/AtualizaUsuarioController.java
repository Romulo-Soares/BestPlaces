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
import com.ifpb.bestplaces01.interfaces.IFileManager;
import java.io.File;

public class AtualizaUsuarioController implements ICommand, IFileManager {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        HttpSession session = req.getSession();
        String emailLogado = (String) session.getAttribute("email");
        String fotoLogada = (String) session.getAttribute("foto");
        
        //Monta caminho da pasta de upload da imagem
        String foto = uploadFile("fotosPerfil", req, 
                req.getPart("fotoPerfil"), req.getParameter("email"));
        
        String sep = File.separator;
        String pathFolder = req.getServletContext().getRealPath("fotosPerfil");
        removeFile(pathFolder + sep + fotoLogada.
                substring(fotoLogada.lastIndexOf(sep)+1));
        
        Usuario u = new Usuario();
        u.setNome(req.getParameter("nome"));
        u.setEmail(req.getParameter("email"));
        u.setCidade(req.getParameter("cidade"));
        u.setFotoPerfil(foto);
        u.setProfissao(req.getParameter("profissao"));
        u.setSenha(req.getParameter("senha"));
        u.setSexo(req.getParameter("sexo"));
        u.setNascimento(req.getParameter("nascimento"));

        UsuarioDAO userDAO = new UsuarioDAO();
        if (userDAO.update(emailLogado, u)) {
            session.setAttribute("email", u.getEmail());
            session.setAttribute("senha", u.getSenha());
            session.setAttribute("nome", u.getNome());
            session.setAttribute("foto", u.getFotoPerfil());
            session.setAttribute("cidade", u.getCidade());
            session.setAttribute("profissao", u.getProfissao());
            session.setAttribute("sexo", u.getSexo());
            session.setAttribute("nascimento", u.getNascimento());

            req.getRequestDispatcher("inicial.jsp").forward(req, res);
        }

    }

}
