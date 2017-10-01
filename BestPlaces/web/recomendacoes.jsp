<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recomendações</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div id="divContPes">
                <div class="row" id="divContMenTit">
                    <div class=" col-md-12 text-center">
                        <h1>Recomendações</h1>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12 text-center" id="divResultado">
                        <h4>Você ainda não possui recomendações :(</h4>
                    </div>
                </div>
                <form action="perfilLocal.jsp" method="post" name="perfilLocal">
                    <div class="form-group">
                        <div id="divResultado">
                            <img id="fotoPesquisa" src="" alt="FotoPerfilLocal" class="img-circle pull-left">
                            <div id="divPes" class="form-group pull-left">
                                <h4>Nome</h4>
                                <h6 id="hDados">Rua: </h6>
                                <h6 id="hDados">Cidade: </h6>
                                <h6 id="hDados">Descricao:</h6>
                                <h6 id="hDados">Estado: </h6>
                                <h6 id="hDados">Tipo: </h6>
                            </div>

                            <div id="divPesbt" class="form-group pull-right">
                                <div class="estrelas  text-center">
                                    <form action="FrontControl" method="post">  
                                        <input type="radio" id="cm_star-empty" name="fb" value="" checked/>
                                        <label for="cm_star-1"><i class="fa"></i></label>
                                        <input type="radio" id="cm_star-1" name="fb" value="1"/>
                                        <label for="cm_star-2"><i class="fa"></i></label>
                                        <input type="radio" id="cm_star-2" name="fb" value="2"/>
                                        <label for="cm_star-3"><i class="fa"></i></label>
                                        <input type="radio" id="cm_star-3" name="fb" value="3"/>
                                        <label for="cm_star-4"><i class="fa"></i></label>
                                        <input type="radio" id="cm_star-4" name="fb" value="4"/>
                                        <label for="cm_star-5"><i class="fa"></i></label>
                                        <input type="radio" id="cm_star-5" name="fb" value="5"/>
                                        <input type="hidden" name="idDoLocal" value="${local.id}"> 
                                        <input type="hidden" name="identificador" value="AvaliacaoLocal"> 
                                        <input type="submit" class="btn-sm btn-danger" role="button" value="Avaliar">
                                    </form>    
                                </div>
                            </div>

                            <div id="divPesbt" class="form-group">

                                <input type="button" name="marcarPresenca" data-toggle="modal" data-target="#modalMarc" class="btn btn-danger btn-md btn-block" role="button" value="Marcar Presença">

                                <div class="modal fade" id="modalMarc" role="dialog">
                                    <div class="modal-dialog">

                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <h4 class="modal-title">Marcar Presença</h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <div class="input-group input-group"> 
                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-calendar"></i></span>
                                                        <input type="date" name="nascimento" data-toggle="tooltip" title="Informe a data que irá comparecer" class="form-control" placeholder="Nascimento" aria-describedby="basic-addon1" required>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="input-group input-group"> 
                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-check"></i></span>
                                                        <input type="text" name="status" class="form-control" placeholder="Status" aria-describedby="basic-addon1" required>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="input-group input-group"> 
                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-comment"></i></span>
                                                        <input type="text" name="comentario" class="form-control" placeholder="Comentário" aria-describedby="basic-addon1" required>
                                                    </div>
                                                </div>
                                                <div class="input-group input-group"> 
                                                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-picture"></i></span>
                                                    <input data-toggle="tooltip" name="fotosPresenca" title="Escolha as fotos da presença" type="file" class="form-control" aria-describedby="basic-addon1" required>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit" class="btn btn-danger" data-dismiss="modal">Marcar Presença</button>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </div>
                        </div>  
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
