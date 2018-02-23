
package com.ifpb.bestplaces.controladores;

import com.ifpb.bestplaces.daos.UsuarioDAO;
import com.ifpb.bestplaces.entidades.Usuario;
import com.ifpb.bestplaces.interfaces.ICommand;
import com.ifpb.bestplaces.interfaces.IFileManager;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExcluiContaController implements ICommand, IFileManager{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) 
            throws SQLException, ClassNotFoundException, IOException, ServletException {
        
        HttpSession session = req.getSession();
        String fotoLogada = (String) session.getAttribute("foto");
        String emailLogado = (String) session.getAttribute("email");
        
        UsuarioDAO userDAO = new UsuarioDAO();
        
        if(userDAO.delete(emailLogado)){
            String sep = File.separator;
            String pathFolder = req.getServletContext().getRealPath("fotosPerfil");
            removeFile(pathFolder + sep + fotoLogada.substring(fotoLogada.lastIndexOf(sep)+1));
            
            res.sendRedirect("index.jsp");
        }else{
            res.sendRedirect("erro.jsp");
        }
    }
    
    
    
}
