
package com.ifpb.bestplaces.servlets;

import com.ifpb.bestplaces.daos.UsuarioDAO;
import com.ifpb.bestplaces.entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "controllerCadastro", urlPatterns = {"/controllerCadastro", "/ControllerCadastro"})
public class controllerCadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate nascimento = LocalDate.parse(request.getParameter("nascimento"),formatter); 
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String profissao = request.getParameter("profissao");
        String sexo = request.getParameter("sexo");
        String foto = request.getParameter("foto");
        
        Usuario u = new Usuario();
        u.setEmail(email);
        u.setNome(nome);
        u.setNascimento(nascimento);
        u.setCidade(cidade);
        u.setFotoPerfil(foto);
        u.setProfissao(profissao);
        u.setSexo(sexo);
        u.setSenha(senha);
        
        UsuarioDAO userDAO = new UsuarioDAO();
      
        try {
            if(userDAO.insert(u)){
                
                request.setAttribute("email", u.getEmail());
                
                request.getRequestDispatcher("computador.jsp").forward(request, response);
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(controllerCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }        
         
    }  

}
