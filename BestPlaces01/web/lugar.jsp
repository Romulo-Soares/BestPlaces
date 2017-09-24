<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lugar</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row contant">
                <%@ include file="menu.jsp"%>
            <div class="col-sm-6" id="divContMen">    
                <div class="row" id="divContMenTit">
                    <div class=" col-md-12 text-center">
                        <h1>Lugares</h1>
                    </div>
                </div>
            </div>
            <div class="col-sm-2 sidenav pull-right" id="divDadosLo">
                    <a name="edLugar" href="editarLugar.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-pencil"></span>Editar lugar</a>
                    <a name="cadLugar" href="cadastroLugar.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-list-alt"></span>Cadastrar Lugar</a>
                    <a name="addFotosLugar" href="fotosLugar.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-picture"></span>Adicionar Fotos</a>
                    <a name="excluirLugar" href="#" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-picture"></span>Excluir Lugar</a> 
            </div>
            </div>
        </div>

    </body>
</html>
