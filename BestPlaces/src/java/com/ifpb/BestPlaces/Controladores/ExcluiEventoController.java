
package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.EventoDAO;
import com.ifpb.BestPlaces.Interfaces.ICommand;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluiEventoController implements ICommand{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) 
            throws SQLException, ClassNotFoundException, IOException, ServletException {
        
        EventoDAO eventoDAO = new EventoDAO();
        
        int idEvento = Integer.parseInt(req.getParameter("idEvento"));
        
        if(eventoDAO.delete(idEvento)){
            res.sendRedirect("evento.jsp");
        }else{
            res.sendRedirect("erro.jsp");
        }
    }
    
    
    
}
