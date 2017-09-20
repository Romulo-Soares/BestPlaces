<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fotos Lugar</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>

        <div class="container" id="divCad">

            <div class="row" id="divCadTit">
                <div class=" col-md-12 text-center">
                    <h1>Fotos Lugar</h1>
                </div>
            </div>

            <form action="FrontControl" method="post" enctype="multipart/form-data">
                <div class="input-group input-group"> 
                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-picture"></i></span>
                    <input data-toggle="tooltip" name="fotoLugar" title="Escolha a foto do lugar" type="file" class="form-control" aria-describedby="basic-addon1" required>
                </div>

                <div class="form-group" id="divBtLogin">
                    <input type="hidden" name="identificador" value="AdicionaFotoLugar"> 
                    <input type="submit" name="adicionar" class="btn btn-danger btn-md btn-block" role="button" value="Adicionar">
                </div>
            </form>

        </div>
        
    </body>
</html>
