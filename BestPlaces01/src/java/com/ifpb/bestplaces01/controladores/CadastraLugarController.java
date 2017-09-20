
package com.ifpb.bestplaces01.controladores;

import com.ifpb.bestplaces01.daos.FotoDAO;
import com.ifpb.bestplaces01.daos.LugarDAO;
import com.ifpb.bestplaces01.entidades.Foto;
import com.ifpb.bestplaces01.entidades.Lugar;
import com.ifpb.bestplaces01.interfaces.ICommand;
import com.ifpb.bestplaces01.interfaces.IFileManager;
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
