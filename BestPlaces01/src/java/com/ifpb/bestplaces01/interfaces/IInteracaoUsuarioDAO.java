
package com.ifpb.bestplaces01.interfaces;

import com.ifpb.bestplaces01.entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface IInteracaoUsuarioDAO {
    public boolean enviarSolicitacaoAmizade(String usuarioInteraginte, 
            String usuarioInteragido) 
            throws ClassNotFoundException, SQLException;
    public boolean gerenciarInteracao(String usuarioInteraginte, 
            String usuarioInteragido, boolean amizade, boolean solicitacao) 
            throws SQLException, ClassNotFoundException;
    public boolean isRequested(String usuarioInteraginte, String usuarioInteragido) 
            throws ClassNotFoundException, SQLException;
    public boolean isUpgradeable (String usuarioInteraginte, String usuarioInteragido) 
            throws ClassNotFoundException, SQLException;
    public int countRequest(String usuarioInteragido) 
            throws SQLException, ClassNotFoundException;
    public List<Usuario> buscaSolicitacoes(String usuarioInteragido) 
            throws SQLException, ClassNotFoundException;
    public boolean isFriend(String usuarioInteraginte, String usuarioInteragido)
            throws ClassNotFoundException, SQLException;
    
}