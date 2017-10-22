<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>

        <div class="col-sm-2 sidenav text-center pull-left" id="divMenu">
            <img id="fotoPerfil" src="${sessionScope.foto}" alt="FotoPerfil" class="img-circle">
            <h4>${sessionScope.nome}</h4>
            <a name="edPerfil" href="editarPerfil.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-pencil"></span>Editar Perfil</a>
            <a name="amigos" href="amigos.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-user"></span><span id="btPerfil" class="glyphicon glyphicon-user"></span>Amigos</a>
            <a name="eventos" href="evento.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-calendar"></span>Eventos</a>
            <a name="locais" href="local.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-map-marker"></span>Locais</a>
        </div>


    </body>
</html>
