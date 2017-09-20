<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lugar</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container">

            <div class="row" id="divCadTit">
                <div class=" col-md-12 text-center">
                    <h1>Lugares</h1>
                </div>
            </div>

            <div class="col-lg-3">
                <a name="edLugar" href="#" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-pencil"></span>Editar lugar</a>
            </div>
            <div class="col-lg-3">
                <a name="cadLugar" href="cadastroLugar.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-list-alt"></span>Cadastrar Lugar</a>
            </div>
            <div class="col-lg-3">
                <a name="addFotosLugar" href="fotosLugar.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-picture"></span>Adicionar Fotos</a>
            </div>
            <div class="col-lg-3">
                <a name="excluirLugar" href="#" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-picture"></span>Excluir Lugar</a>
            </div>
        </div>

    </body>
</html>
