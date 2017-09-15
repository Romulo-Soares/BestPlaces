<%-- 
    Document   : inicial
    Created on : 17/08/2017, 20:13:14
    Author     : Jozimar & Rômulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\bootstrap.min.css">
        <title>Página Inicial</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div class="col-sm-3" id="divMenu">

                <div class="text-center">
                    <h4>${sessionScope.nome}</h4>
                    <img id="fotoPerfil" src="" alt="FotoPerfil" class="img-circle">

                    <a name="edPerfil" href="editarPerfil.jsp" class="btn btn-danger btn-md btn-block" role="button">Editar Perfil</a>
                    <a name="amigos" href="" class="btn btn-danger btn-md btn-block" role="button">Amigos</a>
                    <a name="eventos" href="" class="btn btn-danger btn-md btn-block" role="button">Eventos</a>
                    <a name="locais" href="" class="btn btn-danger btn-md btn-block" role="button">Locais</a>
                    <a name="mensagens" href="" class="btn btn-danger btn-md btn-block" role="button">Mensagens</a></br>
                    <form method="post" action="FrontControl" id="excluir">
                        <input type="hidden" name="identificador" value="ExcluiConta">
                        <a name="excluir" href="#" onclick="document.getElementById('excluir').submit();" class="btn btn-danger btn-md btn-block" role="button">Excluir Conta</a>  
                    </form>

                </div>
            </div>
        </div>
        <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
        <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
    </body>
</html>