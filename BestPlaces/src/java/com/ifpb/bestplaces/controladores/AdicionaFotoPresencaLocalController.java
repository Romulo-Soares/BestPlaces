package com.ifpb.bestplaces.controladores;

import com.ifpb.bestplaces.daos.FotoDAO;
import com.ifpb.bestplaces.entidades.Foto;
import com.ifpb.bestplaces.interfaces.ICommand;
import com.ifpb.bestplaces.interfaces.IFileManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaFotoPresencaLocalController implements ICommand, IFileManager {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, ServletException {

        FotoDAO fotoDAO = new FotoDAO();

        Foto f = new Foto();
        int id = Integer.parseInt(req.getParameter("id"));
        f.setId(id);
        
        String foto = uploadFile("fotosPresenca/" + req.getParameter("fotoPresenca"), req,
                req.getPart("fotoPresenca"), req.getParameter("fotoPresenca") + fotoDAO.interatorFotos_Local("fotos_presenca_local"));
        f.setFoto(foto);
      
        if (fotoDAO.insert(f, "fotos_presenca_local")) {
            if (req.getParameter("adicionarFotoPerfilLocal") != null) {
                res.sendRedirect("perfilLocal.jsp?email=" + req.getParameter("usuario") + "&nome=" + req.getParameter("fotoPresenca"));
            }else if(req.getParameter("adicionarRec") != null){
                res.sendRedirect("recomendacoes.jsp");
            } else {
                res.sendRedirect("local.jsp");
            }   
        } else {
            res.sendRedirect("erro.jsp");
        }
    }

}
