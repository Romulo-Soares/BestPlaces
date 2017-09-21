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
        <div class="container" id="divCad">

            <div class="row" id="divCadTit">
                <div class="col-md-12 text-center">
                    <h1>Perfil</h1>
                </div>
            </div>

            <div class="panel panel-danger">
                <img id="fotoPerfilUsuario" src="${usuario.fotoPerfil}" alt="FotoPerfil" class="img-circle">
                <div class="panel-heading text-center"><div id="divPerfil"><input type="submit" name="addAmigo" class="btn btn-danger btn-md btn-block" role="button" value="Adicionar aos Amigos"></div></div>
                <div class="panel-body text-center">${usuario.nome}</div>
                <div class="panel-body text-center">${usuario.cidade}</div>
                <div class="panel-body text-center">${usuario.email}</div>
                <div class="panel-body text-center">${usuario.profissao}</div>
            </div>
        </div>

    </body>
</html>
