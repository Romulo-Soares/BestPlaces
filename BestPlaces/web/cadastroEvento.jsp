<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\bootstrap.min.css">
        <title>Cadastro Evento</title>
    </head>
    <body>
        <ct:findLocalProfile email="${param.email}" nome="${param.nome}"/>

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
                            <h1>Cadastro Evento</h1>
                        </div>
                    </div>
                    <form action="FrontControl" method="post" enctype="multipart/form-data">

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-globe"></i></span>
                                <input type="text" name="nome" class="form-control" placeholder="Nome" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-calendar"></i></span>
                                <input type="date" name="data" data-toggle="tooltip" title="Informe a data do evento" class="form-control" placeholder="Data" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-time"></i></span>
                                <input type="time" name="hora" data-toggle="tooltip" title="Informe a hora do evento" class="form-control" placeholder="Hora" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-map-marker"></i></span>
                                <input type="text" name="local" value="${local.nome}" class="form-control" placeholder="Local" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group input-group"> 
                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-list-alt"></i></span>
                                <input type="text" name="descricao" class="form-control" placeholder="Descrição" aria-describedby="basic-addon1" required>
                            </div>
                        </div>

                        <div class="form-group" id="divBtLogin">
                            <input type="hidden" name="idLocal" value="${local.id}">
                            <input type="hidden" name="identificador" value="CadastraEvento"> 
                            <input type="submit" name="adicionar" class="btn btn-danger btn-md btn-block" role="button" value="Cadastrar">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
        <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>

    </body>
</html>