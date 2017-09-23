<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Usuário</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <ct:findUserByName nome="${param.nome}" emailExcecao="${sessionScope.email}"/>
        <div class="container" id="divCad">

            <div class="row" id="divCadTit">
                <div class=" col-md-12 text-center">
                    <h1>Pesquisar Usuários</h1>
                </div>
            </div>

            <c:if test="${empty usuarios}">
                <div class="form-group">
                    <div class="col-md-12 text-center" id="divResultado">
                        <h4>Não encontramos nenhum usuário :(</h4>
                    </div>
                </div>
            </c:if>
            <c:if test="${not empty usuarios and not empty param.nome}">
                <c:forEach var="usuarios" items="${usuarios}">
                    <form action="perfil.jsp" method="post" name="perfil">
                        <div class="form-group">
                            <div id="divResultado">
                                <img id="fotoPesquisa" src="${usuarios.fotoPerfil}" alt="FotoPerfil" class="img-circle">
                                <div id="divPes" class="form-group">
                                    <h4>${usuarios.nome}</h4>
                                    <h6 id="hDados">Cidade: ${usuarios.cidade}</h6>
                                    <h6 id="hDados">Profissão: ${usuarios.profissao}</h6>
                                </div>
                                <div id="divPesbt" class="form-group">
                                    <input name="email" type="hidden" value="${usuarios.email}">
                                    <input type="submit" class="btn btn-danger btn-md btn-block" role="button" value="Visualizar Perfil"> 
                                </div>
                            </div>  
                        </div>
                    </form>
                </c:forEach>
            </c:if>   
        </div>
    </body>
</html>
