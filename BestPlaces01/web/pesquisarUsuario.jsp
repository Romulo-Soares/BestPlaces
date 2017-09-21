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
        <ct:findUserByName nome="${param.nome}"/>
        <div class="container" id="divCad">

            <div class="row" id="divCadTit">
                <div class=" col-md-12 text-center">
                    <h1>Pesquisar Usuários</h1>
                </div>
            </div>

            <div class="form-group">
                <form action="pesquisarUsuario.jsp" method="post" name="pesquisarUsuario">   
                    <div class="input-group input-group">
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" name="nome" class="form-control" placeholder="Nome do Usuário" aria-describedby="basic-addon1" required>
                        <div class="input-group-btn">
                            <input type="hidden" name="identificador" value="PesquisarUsuario"> 
                            <button class="btn btn-danger btn-md btn-block" role="button" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </div>
                </form>
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
                    <form action="Perfil.jsp" method="post" name="perfil">
                        <div class="form-group">
                            <div id="divResultado">
                                <img id="fotoPesquisa" src="${usuarios.fotoPerfil}" alt="FotoPerfil" class="img-circle">
                                <div id="divPes" class="form-group">
                                    <h4>${usuarios.nome}</h4>
                                    <h9>${usuarios.cidade}</h9><br>
                                    <h9>${usuarios.profissao}</h9>
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
