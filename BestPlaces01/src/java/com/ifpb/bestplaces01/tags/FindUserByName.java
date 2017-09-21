
package com.ifpb.bestplaces01.tags;

import com.ifpb.bestplaces01.daos.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FindUserByName extends SimpleTagSupport {
    
    private String nome;
    
    @Override
    public void doTag(){
        
        UsuarioDAO userDAO = new UsuarioDAO();
        try {
            getJspContext().setAttribute("usuarios", userDAO.readUserByName(nome));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FindUserByName.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}