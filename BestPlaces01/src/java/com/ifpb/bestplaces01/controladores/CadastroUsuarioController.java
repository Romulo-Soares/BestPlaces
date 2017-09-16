package com.ifpb.bestplaces01.controladores;

import com.ifpb.bestplaces01.daos.UsuarioDAO;
import com.ifpb.bestplaces01.entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifpb.bestplaces01.interfaces.ICommand;
import com.ifpb.bestplaces01.interfaces.IFileManager;

public class CadastroUsuarioController implements ICommand, IFileManager {

    @Override
    public final void execute(HttpServletRequest req, HttpServletResponse res)
            throws SQLException, ClassNotFoundException, IOException, ServletException {

        String foto = uploadFile("fotosPerfil", req, 
                req.getPart("fotoPerfil"), req.getParameter("email"));

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
        if (userDAO.insert(u)) {
            res.sendRedirect("index.jsp");
            
        }

    }

}
