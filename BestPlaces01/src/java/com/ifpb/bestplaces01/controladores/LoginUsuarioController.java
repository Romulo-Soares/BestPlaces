
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginUsuarioController implements ICommand, IAutenticavelUsuario{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) 
            throws SQLException, ClassNotFoundException, IOException, ServletException {
        
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        
        if(autenticarUsuario(email, senha)){
             req.getRequestDispatcher("inicial.jsp").forward(req, res);
        }else{
             res.sendRedirect("index.jsp");
        }
        
    }

    @Override
    public boolean autenticarUsuario(String email, String senha) {
        UsuarioDAO userDAO = new UsuarioDAO();
        
        try {
            Usuario u = userDAO.read(email);
            
            if(u != null)
                return u.getEmail().equals(email) && u.getSenha().equals(senha);
            else return false;
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
}
