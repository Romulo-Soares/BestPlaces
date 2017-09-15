
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

public class AtualizaUsuarioController implements ICommand{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        
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
        
        if(userDAO.read(emailLogado).getEmail().equals(email)){
            userDAO.update(u);
            
             session.setAttribute("email", email);
             session.setAttribute("senha", senha);

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
