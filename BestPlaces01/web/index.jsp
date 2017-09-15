
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\bootstrap.min.css">
        <title>Login</title>
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" id="linkMenu"><span class="glyphicon glyphicon-log-in"></span> BestPlaces</a>
                </div>
            </div>
        </nav>


        <div class="container" id="divLog">

            <div class="row" id="divImg">
                <div class=" col-md-12 text-center">
                    <img src="Imagens\logo.png" class="img-responsive" alt="Logo">
                </div>
            </div>

            <form method="post" action="FrontControl">
                <div class="form-group">
                    <input type="email" name="email" class="form-control" placeholder="Email" aria-describedby="basic-addon1"> 
                </div>

                <div class="form-group"> 
                    <input type="password" name="senha" class="form-control" placeholder="Senha" aria-describedby="basic-addon1">
                </div> 

                <div class="form-group" id="divBtLogin">
                    <input type="hidden" name="identificador" value="LoginUsuario">
                    <input type="submit" name="login" value="Login" class="btn btn-danger btn-md btn-block" role="button">
                </div>
            </form>

            <div class="form-group" id="divBtLogin">
                <a name="cadastrar" href="cadastroUsuario.jsp" class="btn btn-danger btn-md btn-block" role="button">Cadastrar</a>
            </div>

        </div>

        <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
        <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

    </body>
</html>
