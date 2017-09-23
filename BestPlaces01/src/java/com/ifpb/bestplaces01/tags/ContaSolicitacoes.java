
package com.ifpb.bestplaces01.tags;

import com.ifpb.bestplaces01.daos.InteracaoUsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ContaSolicitacoes extends SimpleTagSupport{
    
    private String usuarioInteragido;
    
    @Override
    public void doTag(){
        
        InteracaoUsuarioDAO iuDAO = new InteracaoUsuarioDAO();
        try {
            
            int qntSolicitacoes = iuDAO.countRequest(usuarioInteragido);
            getJspContext().setAttribute("qntSolicitacoes", qntSolicitacoes);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContaSolicitacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getUsuarioInteragido() {
        return usuarioInteragido;
    }

    public void setUsuarioInteragido(String usuarioInteragido) {
        this.usuarioInteragido = usuarioInteragido;
    }
      
}
