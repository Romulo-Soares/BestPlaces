<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensagens</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container" id="divCad">

            <div class="row" id="divCadTit">
                <div class=" col-md-12 text-center">
                    <h1>Mensagens</h1>
                </div>
            </div>

            <div class="form-group">
                <div id="divResultadoMens">
                    <img id="fotoPesquisa" src="Imagens/logo2.png" alt="FotoPerfil" class="img-circle pull-left">
                    <div id="divPes" class="form-group pull-left">
                        <h4>Nome do Usuário</h4>
                        <button type="button" class="btn btn-danger btn-md" data-toggle="modal" data-target="#myModal">Responder</button>

                        <div class="modal fade" id="myModal" role="dialog">
                            <div class="modal-dialog modal-md">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Nome do Usuário</h4>
                                    </div>
                                    <div class="modal-body">

                                        <div id="divMens">
                                            <div class="panel panel-default">
                                                <div id="divMensAmigo" class="panel-heading">Mensagem Amigo </div>
                                            </div>

                                            <div class="panel panel-danger">
                                                <div id="divMensAmigo" class="panel-heading">Minha Mensagem</div>
                                            </div>

                                        </div>

                                        <textarea class="form-control" cols="10" rows="2"></textarea>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-danger" role="button" data-dismiss="modal">Enviar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
