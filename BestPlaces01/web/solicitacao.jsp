<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitação</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container" id="divCad">

            <div class="row" id="divCadTit">
                <div class=" col-md-12 text-center">
                    <h1>Solicitações</h1>
                </div>
            </div>    

            <div class="form-group">
                <div id="divResultado">
                    <img id="fotoAmigo" src="Imagens/logo2.png" alt="FotoPerfil" class="img-circle">

                    <div id="divSoliTit" class="form-group">
                        <h4>Nome do Usuario</h4>   
                    </div>

                    <div id="divSoli" class="form-group">
                        <input type="submit" name="enviarMensagem" class="btn btn-danger btn-md btn-block" role="button" value="Aceitar Amizade"> 
                        <input type="submit" name="desfazerAmizade" class="btn btn-danger btn-md btn-block" role="button" value="Rejeitar Amizade">  
                    </div>
                </div>  
            </div>

        </div>
    </body>
</html>
