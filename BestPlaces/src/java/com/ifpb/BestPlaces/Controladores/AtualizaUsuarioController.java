package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.UsuarioDAO;
import com.ifpb.BestPlaces.Entidades.Usuario;
import com.ifpb.BestPlaces.Interfaces.ICommand;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ifpb.BestPlaces.Interfaces.IFileManager;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AtualizaUsuarioController implements ICommand, IFileManager {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        HttpSession session = req.getSession();
        String emailLogado = (String) session.getAttribute("email");
        String fotoLogada = (String) session.getAttribute("foto");

        String data = req.getParameter("nascimento");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(data, formatter);

        if (date.isAfter(LocalDate.now())) {
            res.sendRedirect("erroDataUp.jsp");
        } else {

            String sep = File.separator;
            String pathFolder = req.getServletContext().getRealPath("fotosPerfil");
            removeFile(pathFolder + fotoLogada.substring(fotoLogada.lastIndexOf(sep)));
            
            //Monta caminho da pasta de upload da imagem
            String foto = uploadFile("fotosPerfil", req,
                    req.getPart("fotoPerfil"), req.getParameter("email"));
            
            Usuario u = new Usuario();
            u.setNascimento(req.getParameter("nascimento"));
            u.setFotoPerfil(foto);
            u.setNome(req.getParameter("nome"));
            u.setEmail(req.getParameter("email"));
            u.setCidade(req.getParameter("cidade"));
            u.setProfissao(req.getParameter("profissao"));
            u.setSenha(req.getParameter("senha"));
            u.setSexo(req.getParameter("sexo"));

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
            } else {
                res.sendRedirect("erro.jsp");
            }
        }

    }

}