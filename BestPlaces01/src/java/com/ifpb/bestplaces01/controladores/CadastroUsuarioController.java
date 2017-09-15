
package com.ifpb.bestplaces01.controladores;

import com.ifpb.bestplaces01.daos.UsuarioDAO;
import com.ifpb.bestplaces01.entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifpb.bestplaces01.interfaces.ICommand;
import com.ifpb.bestplaces01.interfaces.IUploadFile;
import javax.servlet.http.Part;

public class CadastroUsuarioController implements ICommand, IUploadFile{
    
    @Override
    public final void execute(HttpServletRequest req, HttpServletResponse res) 
            throws SQLException, ClassNotFoundException, IOException, ServletException {
        
       String nome = req.getParameter("nome");
       String email = req.getParameter("email");
       String cidade = req.getParameter("cidade");
       String sexo = req.getParameter("sexo");
       String profissao = req.getParameter("profissao");
       String nascimento = req.getParameter("nascimento");
       String senha = req.getParameter("senha");
       
       Part part = req.getPart("fotoPerfil");
       String pathName = "\\"+ req.getServletContext().getRealPath("fotosPerfil");   
       
       Usuario u = new Usuario();
       u.setNome(nome);
       u.setEmail(email);
       u.setCidade(cidade);
       u.setFotoPerfil(uploadFile(pathName, part));
       u.setProfissao(profissao);
       u.setSenha(senha);
       u.setSexo(sexo);
       u.setNascimento(nascimento);
       
       UsuarioDAO userDAO = new UsuarioDAO();
       if(userDAO.insert(u)){
           res.sendRedirect("index.jsp");
       }
        
    }
    
}
