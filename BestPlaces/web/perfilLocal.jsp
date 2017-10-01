<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Local</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <ct:findLocalProfile email="${param.email}" nome="${param.nome}"/>
        <ct:solicitado usuarioInteraginte="${sessionScope.email}" usuarioInteragido="${usuario.email}"/>

        <div class="container" id="divCad">
            <div class="row" id="divContMenTit">
                <div class="col-md-12 text-center">
                    <h1>Perfil Local</h1>
                </div>
            </div>

            <div class="panel panel-danger">
                <ct:retornaFotoLocal idLocal="${local.id}"/>

                <c:if test="${not empty fotoLocal}">
                    <img id="fotoPerfilUsuario" src="${fotoLocal.foto}" alt="FotoPerfil" class="img-circle">
                </c:if>
                <div class="panel-heading text-center">
                    <form action="FrontControl" method="post" name="enviarSolicitacao">
                        <div id="divPerfil">
                            <input type="hidden" name="identificador" value="GerenciaInteracao">
                            <input type="hidden" name="usuarioInteragido" value="${usuario.email}">
                            <c:choose>
                                <c:when test="${not amigo}">
                                    <c:if test="${not solicitado}">

                                        <div class="form-group">
                                            <input type="button" name="fazerSolicitacao" data-toggle="modal" data-target="#modalRec" class="btn btn-danger btn-md btn-block" role="button" value="Recomendar">

                                            <div class="modal fade" id="modalRec" role="dialog">
                                                <div class="modal-dialog">

                                                    <!-- Modal content-->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                            <h4 class="modal-title">Recomendar</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="form-group">
                                                                <div class="input-group input-group"> 
                                                                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user"></i></span>
                                                                    <input type="email" name="email" class="form-control" placeholder="Email do amigo" aria-describedby="basic-addon1" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="submit" class="btn btn-danger" data-dismiss="modal">Recomendar</button>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>

                                        <input type="button" name="marcarPresenca" data-toggle="modal" data-target="#modalMarc" class="btn btn-danger btn-md btn-block" role="button" value="Marcar Presença">

                                        <div class="modal fade" id="modalMarc" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
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

                                    </c:if>
                                    <c:if test="${solicitado}"> 
                                        <h5 class="text-success"><i class="glyphicon glyphicon-ok"></i> Solicitação enviada</h5>
                                        <input type="submit" name="desfazerSolicitacao" class="btn btn-danger btn-md btn-block" role="button" value="Desfazer Solicitação">
                                    </c:if>
                                </c:when>
                                <c:otherwise>
                                    <h5 class="text-success"><i class="glyphicon glyphicon-user"></i> Amigo</h5>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </form>
                </div>
                <div class="panel-body text-center pull-left">Nome: ${local.nome}</div>
                <div class="panel-body text-center">Rua: ${local.rua}</div>
                <div class="panel-body text-center pull-left">Cidade: ${local.cidade}</div>
                <div class="panel-body text-center">Descricao: ${local.descricao}</div>
                <div class="panel-body text-center pull-left">Estado: ${local.estado}</div>
                <div class="panel-body text-center">Tipo: ${local.tipo}</div>
                <div class="panel-body text-center">Deixe sua avaliação abaixo:</div>
                <div class="estrelas panel-body text-center">
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
        </div>

    </body>
</html>
