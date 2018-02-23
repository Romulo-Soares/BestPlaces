
package com.ifpb.bestplaces.controladores;

import com.ifpb.bestplaces.daos.LocalDAO;
import com.ifpb.bestplaces.interfaces.ICommand;
import com.ifpb.bestplaces.interfaces.IFileManager;
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
