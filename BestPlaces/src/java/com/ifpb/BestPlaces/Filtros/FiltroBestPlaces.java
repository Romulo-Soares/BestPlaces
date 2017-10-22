package com.ifpb.BestPlaces.Filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "filtroBestPlaces", 
        urlPatterns = {"/inicial.jsp", "/editarPerfil.jsp", "/amigos.jsp", 
            "/cadastroEvento.jsp", "/cadastroLocal.jsp", "/evento.jsp", 
            "/local.jsp", "/mensagem.jsp", "/menu.jsp", 
            "/menuEd.jsp", "/perfil.jsp", "/perfilEvento.jsp",
            "/perfilLocal.jsp", "/pesquisarEvento.jsp", "/pesquisarLocal.jsp",
            "/pesquisarLocalEvento.jsp", "/pesquisarUsuario.jsp", "/recomendacoes.jsp", "/solicitacao.jsp"})
public class FiltroBestPlaces implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) req).getSession();

        String usuario = (String) session.getAttribute("email");

        if (usuario == null) {

            ((HttpServletResponse) res).sendRedirect("erroFiltro.jsp");

        } else {

            chain.doFilter(req, res);

        }
    }

    @Override
    public void destroy() {

    }

}
