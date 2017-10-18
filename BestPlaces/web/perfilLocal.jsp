<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Local</title>
        <%@ include file="navbar.jsp"%>
        <ct:findLocalProfile email="${param.email}" nome="${param.nome}"/>
        <ct:countStar idLocal="${local.id}"/>
    </head>
    <body onload="setaDadosStar('${valorAvaliacao}')">

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

                    <div id="divPerfil">


                        <div class="form-group">

                            <c:if test="${not empty param.isRecommended}">
                                O Usuario já recomendado para este local
                            </c:if>

                            <input type="button" name="recomendar" data-toggle="modal" data-target="#modalRec" class="btn btn-danger btn-md btn-block" role="button" value="Recomendar">

                            <div class="modal fade" id="modalRec" role="dialog">
                                <div class="modal-dialog">
                                    <form action="FrontControl?identificador=RecomendaLocal&id_local=${local.id}&nomeLocal=${param.nome}" method="post" name="recomendacaoLocal">
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
                                                        <input type="email" name="usuario_destino" class="form-control" placeholder="Email do amigo" aria-describedby="basic-addon1" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit" class="btn btn-danger" >Recomendar</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <c:if test="${not empty param.isMarked}">
                            O Local já está marcado para esta data
                        </c:if>          

                        <input type="button" name="marcarPresenca" data-toggle="modal" data-target="#modalMarc" class="btn btn-danger btn-md btn-block" role="button" value="Marcar Presença">

                        <div class="modal fade" id="modalMarc" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Marcar Presença</h4>
                                    </div>
                                    <form action="FrontControl?identificador=PresencaLocal&id_local=${local.id}&nomeLocal=${param.nome}" method="post" name="marcar presenca" enctype="multipart/form-data">
                                        <div class="modal-body">

                                            <div class="form-group">
                                                <div class="input-group input-group"> 
                                                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-calendar"></i></span>
                                                    <input type="date" name="data" data-toggle="tooltip" title="Informe a data que irá comparecer" class="form-control" placeholder="Comparecimento" aria-describedby="basic-addon1" required>
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
                                                <input data-toggle="tooltip" name="foto" title="Escolha as fotos da presença" type="file" class="form-control" aria-describedby="basic-addon1" required>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-danger">Marcar Presença</button>
                                        </div>
                                    </form>
                                </div>

                            </div>
                        </div>

                    </div>

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
                        <input type="hidden" name="email" value="${local.usuario}"> 
                        <input type="hidden" name="nome" value="${local.nome}"> 
                        
                        <c:choose>
                            <c:when test="${valorAvaliacao != 0}">
                                <button type="submit" class="btn-sm btn-danger" name="reavaliar" role="button">Reavaliar</button>
                            </c:when>
                            <c:otherwise>
                                <button type="submit" class="btn-sm btn-danger" name="avaliar" role="button">Avaliar</button>
                            </c:otherwise>
                        </c:choose>
                        
                    </form>    

                    <script type="text/javascript">
                        function setaDadosStar(valorAvaliacao) {
                            var radio = document.getElementById("cm_star-" + valorAvaliacao);
                            radio.checked = "true";
                        }                       
                    </script>
                    
                </div>
            </div>
        </div>

    </body>
</html>
