<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Usuário</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <ct:findUserProfile email="${param.email}"/>
        <ct:solicitado usuarioInteraginte="${sessionScope.email}" usuarioInteragido="${usuario.email}"/>

        <div class="container" id="divCad">
            <div class="row" id="divContMenTit">
                <div class="col-md-12 text-center">
                    <h1>Perfil</h1>
                </div>
            </div>
            <div class="panel panel-danger">
                <img id="fotoPerfilUsuario" src="${usuario.fotoPerfil}" alt="FotoPerfil" class="img-circle">
                <div class="panel-heading text-center">
                    <form action="FrontControl" method="post" name="enviarSolicitacao">
                        <div id="divPerfil">
                            <input type="hidden" name="identificador" value="GerenciaInteracao">
                            <input type="hidden" name="usuarioInteragido" value="${usuario.email}">
                            <c:choose>
                                <c:when test="${not amigo}">
                                    <c:if test="${not solicitado}">    
                                        <input type="submit" name="fazerSolicitacao" class="btn btn-success btn-md btn-block" role="button" value="Solicitar Amizade">
                                    </c:if>
                                    <c:if test="${solicitado}"> 
                                        <h5 class="text-success"><i class="glyphicon glyphicon-ok"></i> Solicitação enviada</h5>
                                        <input type="submit" name="desfazerSolicitacao" class="btn btn-danger btn-md btn-block" role="button" value="Desfazer Solicitação">
                                    </c:if>
                                </c:when>
                                <c:otherwise>
                                    <h5 class="text-success"><i class="glyphicon glyphicon-user"></i> Amigo</h5>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </form>
                </div>
                <div class="list-group-item text-center">Nome: ${usuario.nome}</div>
                <div class="list-group-item text-center">Cidade: ${usuario.cidade}</div>
                <div class="list-group-item text-center">E-mail: ${usuario.email}</div>
                <div class="list-group-item text-center">Profissão: ${usuario.profissao}</div>
            </div>
        </div>

    </body>
</html>
