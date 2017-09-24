<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Amigos</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row contant">
                <%@ include file="menu.jsp"%> 
                <div class="col-sm-6" id="divContMen">
                    <div class="row" id="divContMenTit">
                        <div class=" col-md-12 text-center">
                            <h1>Amigos</h1>
                        </div>
                    </div>    

                    <div class="form-group">
                        <div id="divResultado">
                            <img id="fotoAmigo" src="Imagens/logo2.png" alt="FotoPerfil" class="img-circle pull-left">

                            <div id="divSoliTit" class="form-group pull-left">
                                <h4>Nome do Usuario</h4> 
                                <h5 id="hDados">Endereço: Endereço</h5> 
                                <h5 id="hDados">Profissão: Profissão</h5> 
                            </div>

                            <div id="divSoli" class="form-group">
                                <input type="submit" name="enviarMensagem" data-toggle="modal" data-target="#myModal" id="btPes" class="btn btn-danger btn-md btn-block" role="button" value="Enviar Mensagem"> 
                                <input type="submit" name="desfazerAmizade" id="btPes" class="btn btn-danger btn-md btn-block" role="button" value="Desfazer Amizade">  

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

                    <div class="form-group">
                        <div class="col-md-12 text-center" id="divResultado">
                            <h4>Você ainda não possui amigos :(</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
