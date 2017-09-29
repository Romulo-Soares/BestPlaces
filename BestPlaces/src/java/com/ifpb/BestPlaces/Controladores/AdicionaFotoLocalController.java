
package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.FotoDAO;
import com.ifpb.BestPlaces.Entidades.Foto;
import com.ifpb.BestPlaces.Interfaces.ICommand;
import com.ifpb.BestPlaces.Interfaces.IFileManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaFotoLocalController implements ICommand, IFileManager{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        
       FotoDAO fotoDAO = new FotoDAO();
       Foto f = new Foto();
       int id = Integer.parseInt(req.getParameter("id"));
       f.setId(id);
       
       String foto = uploadFile("fotosLocal/" + req.getParameter("nome"), req, 
       req.getPart("fotoLocal"), req.getParameter("nome"));
       f.setFoto(foto);
       
       if(fotoDAO.insert(f, "fotos_local")){
           res.sendRedirect("local.jsp");
       }else{
           res.sendRedirect("erro.jsp");
       }
                
    }
       
}
