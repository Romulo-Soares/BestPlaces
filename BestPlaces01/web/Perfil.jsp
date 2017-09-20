<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Usuário</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container" id="divCad">

            <div class="row" id="divCadTit">
                <div class="col-md-12 text-center">
                    <h1>Perfil</h1>
                </div>
            </div>

            <div class="panel panel-danger">
                <img id="fotoPerfilUsuario" src="Imagens/logo2.png" alt="FotoPerfil" class="img-circle">
                <div class="panel-heading text-center"><div id="divPerfil"><input type="submit" name="addAmigo" class="btn btn-danger btn-md btn-block" role="button" value="Adicionar aos Amigos"></div></div>
                <div class="panel-body text-center">Nome do Usuário</div>
                <div class="panel-body text-center">Cidade</div>
                <div class="panel-body text-center">E-mail</div>
                <div class="panel-body text-center">Profissão</div>
            </div>
        </div>

    </body>
</html>
