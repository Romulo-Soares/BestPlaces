
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

public class AdicionaFotoLugarController implements ICommand, IFileManager{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
        
       FotoDAO fotoDAO = new FotoDAO();
       Foto f = new Foto();
       
       String foto = uploadFile("fotosLugar", req, 
       req.getPart("fotoLugar"), req.getParameter("email"));
       f.setFoto(foto);
       
       if(fotoDAO.insert(f, "lugar")){
           res.sendRedirect("lugar.jsp");
       }else{
           res.sendRedirect("erro.jsp");
       }
                
    }
       
}
