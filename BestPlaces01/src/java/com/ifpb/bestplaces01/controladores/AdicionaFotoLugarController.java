
package com.ifpb.bestplaces01.controladores;

import com.ifpb.bestplaces01.daos.FotoDAO;
import com.ifpb.bestplaces01.entidades.Foto;
import com.ifpb.bestplaces01.interfaces.ICommand;
import com.ifpb.bestplaces01.interfaces.IFileManager;
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
