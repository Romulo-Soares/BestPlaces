<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\bootstrap.min.css">
        <title>Cadastro Lugar</title>
    </head>
    <body>

        <nav class="navbar navbar-inverse" id="navBarNav">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" id="linkMenu" href="inicial.jsp"><span class="glyphicon glyphicon-list-alt"></span> BestPlaces</a>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row contant">
                <%@ include file="menu.jsp"%> 
                <div class="col-sm-6" id="divContMen">
                    <div class="row" id="divContMenTit">
                        <div class=" col-md-12 text-center">
                            <h1>Cadastro Lugar</h1>
                        </div>
                    </div>
                    <form action="FrontControl" method="post" enctype="multipart/form-data">

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" name="nome" class="form-control" placeholder="Nome" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-road"></i></span>
                                <input type="text" name="rua" class="form-control" placeholder="Rua" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-home"></i></span>
                                <input type="text" name="cidade" class="form-control" placeholder="Cidade" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-list-alt"></i></span>
                                <input type="text" name="descricao" class="form-control" placeholder="Descrição" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-flag"></i></span>
                                <input type="text" name="estado" class="form-control" placeholder="Estado" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-text-size"></i></span>
                                <input type="text" name="tipo" class="form-control" placeholder="Tipo" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group" id="divBtLogin">
                            <input type="hidden" name="identificador" value="CadastraLugar"> 
                            <input type="submit" name="adicionar" class="btn btn-danger btn-md btn-block" role="button" value="Adicionar">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
        <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

    </body>
</html>