
package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.LocalDAO;
import com.ifpb.BestPlaces.Interfaces.ICommand;
import com.ifpb.BestPlaces.Interfaces.IFileManager;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluiLocalController implements ICommand, IFileManager{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) 
            throws SQLException, ClassNotFoundException, IOException, ServletException {
        
        LocalDAO localDAO = new LocalDAO();
        
        int idLocal = Integer.parseInt(req.getParameter("idLocal"));
        
        if(localDAO.delete(idLocal)){
            String sep = File.separator;
            String pathFolder = req.getServletContext().getRealPath("fotosLocal" + sep + req.getParameter("localNome"));
            System.out.println(pathFolder);
            deleteFolderWithFile(pathFolder);
            res.sendRedirect("local.jsp");
        }else{
            res.sendRedirect("erro.jsp");
        }
    }
    
    
    
}
