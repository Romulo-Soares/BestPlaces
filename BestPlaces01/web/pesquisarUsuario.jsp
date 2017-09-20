<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Usuário</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container" id="divCad">

            <div class="row" id="divCadTit">
                <div class=" col-md-12 text-center">
                    <h1>Pesquisar Usuários</h1>
                </div>
            </div>

            <div class="form-group">
                <div class="input-group input-group"> 
                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user"></i></span>
                    <input type="text" name="nome" class="form-control" placeholder="Nome do Usuário" aria-describedby="basic-addon1" required>
                    <div class="input-group-btn">
                        <button class="btn btn-danger btn-md btn-block" role="button" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div id="divResultado">
                    <img id="fotoPesquisa" src="Imagens/logo2.png" alt="FotoPerfil" class="img-circle">
                    <div id="divPes" class="form-group">
                        <h4>Nome do Usuario</h4> 
                        <input type="submit" name="visualizarPerfil" class="btn btn-danger btn-md btn-block" role="button" value="Visualizar Perfil">  
                    </div>
                </div>  
            </div>

            <div class="form-group">
                <div class="col-md-12 text-center" id="divResultado">
                    <h4>Não encontramos nenhum usuário :(</h4>
                </div>
            </div>

        </div>

    </body>
</html>
