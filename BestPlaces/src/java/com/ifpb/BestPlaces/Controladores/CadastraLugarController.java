
package com.ifpb.BestPlaces.Controladores;

import com.ifpb.BestPlaces.DAOs.FotoDAO;
import com.ifpb.BestPlaces.DAOs.LugarDAO;
import com.ifpb.BestPlaces.Entidades.Foto;
import com.ifpb.BestPlaces.Entidades.Lugar;
import com.ifpb.BestPlaces.Interfaces.ICommand;
import com.ifpb.BestPlaces.Interfaces.IFileManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CadastraLugarController implements ICommand, IFileManager{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {
       
       HttpSession session = req.getSession();
       
       LugarDAO lugarDAO = new LugarDAO();
       
       Lugar l = new Lugar();
       
       l.setUsuario((String) session.getAttribute("email"));
       l.setNome(req.getParameter("nome"));
       l.setRua(req.getParameter("rua"));
       l.setCidade(req.getParameter("cidade"));
       l.setDescricao(req.getParameter("descricao"));
       l.setEstado(req.getParameter("estado"));
       l.setTipo(req.getParameter("tipo"));
        
       if(lugarDAO.insert(l)){
           res.sendRedirect("inicial.jsp");
       }else{
           res.sendRedirect("erro.jsp");    
       }
    }
    
}
