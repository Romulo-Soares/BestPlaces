package com.ifpb.bestplaces.tags;

import com.ifpb.bestplaces.daos.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FindUserByName extends SimpleTagSupport {

    private String nome;
    private String emailExcecao;

    @Override
    public void doTag() {

        UsuarioDAO userDAO = new UsuarioDAO();
        try {
            getJspContext().setAttribute("usuarios", userDAO.readUserByName(nome, emailExcecao));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FindUserByName.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getEmailExcecao() {
        return emailExcecao;
    }

    public void setEmailExcecao(String emailExcecao) {
        this.emailExcecao = emailExcecao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
