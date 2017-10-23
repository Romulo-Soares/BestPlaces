<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Evento</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <ct:findEventoProfile idEvento="${param.idEvento}"/>
        <%@ include file="menu.jsp"%>
        <div class="container col-sm-6" id="divContMen">
            <div class="row" id="divContMenTit">
                <div class="col-md-12 text-center">
                    <h1>Perfil Evento</h1>
                </div>
            </div>

            <div class="panel panel-danger">
                <ct:retornaFotoLocal idLocal="${evento.idLocal}"/>

                <c:if test="${not empty fotoLocal}">
                    <img id="fotoPerfilUsuario" src="${fotoLocal.foto}" alt="FotoPerfil" class="img-circle">
                </c:if>

                <div class="panel-heading text-center">
                    <div id="divPerfil">
                        <div class="form-group">

                            <form action="FrontControl" method="post" name="divulgarEvento">
                                <input type="hidden" name="identificador" value="DivulgaEvento">
                                <input type="hidden" name="idEvento" value="${evento.id}">
                                <ct:eventoDivulgado idEvento="${evento.id}" usuario="${sessionScope.email}"/>
                                <c:choose>
                                    <c:when test="${divulgado == false}">
                                        <input type="submit" name="divulgar" class="btn btn-danger btn-md btn-block" role="button" value="Divulgar">
                                    </c:when>
                                    <c:otherwise>
                                        <h5 class="text-success"><i class="glyphicon glyphicon-ok"></i> Evento Divulgado</h5>
                                        <input type="submit" name="desfazerDivulgacao" class="btn btn-danger btn-md btn-block" role="button" value="Desfazer Divulgacao">
                                    </c:otherwise>
                                </c:choose>
                            </form>

                        </div>

                        <c:if test="${not empty param.isMarked}">
                            O Evento já está marcado para esta data
                        </c:if>          

                        <input type="button" name="marcarPresenca" data-toggle="modal" data-target="#${evento.id}" class="btn btn-danger btn-md btn-block" role="button" value="Marcar Presença">

                        <div class="modal fade" id="${evento.id}" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Marcar Presença</h4>
                                    </div>

                                    <form action="FrontControl" method="post" name="marcar presenca" enctype="multipart/form-data">
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
                                                <input data-toggle="tooltip" name="foto" title="Escolha a foto da presença" type="file" class="form-control" aria-describedby="basic-addon1" required>
                                            </div><br>

                                            <ct:verificaPresencaEvento idEvento="${evento.id}" usuario="${sessionScope.email}"/>
                                            <c:if test="${presenciado == true}" >
                                                <div class="form-group">
                                                    <div class="input-group input-group"> 
                                                        <input type="button" name="fotosPresencaEvento" data-toggle="modal" data-target="#${evento.id}-1" class="btn btn-danger btn-md btn-block" role="button" value="Add Fotos">
                                                    </div>
                                                </div>
                                            </c:if>

                                        </div>
                                        <div class="modal-footer">
                                            <input type="hidden" name="identificador" value="PresencaEvento">
                                            <input type="hidden" name="idEvento" value="${evento.id}">
                                            <input type="hidden" name="nome" value="${evento.nome}">
                                            <button type="submit" class="btn btn-danger">Marcar Presença</button>
                                        </div>
                                    </form>
                                </div>

                            </div>
                        </div>

                        <div class="modal fade" id="${evento.id}-1" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Fotos Presença</h4>
                                    </div>

                                    <div class="modal-body">
                                        <form action="FrontControl?fotoPresencaEvento=${evento.nome}&id=${evento.id}" method="post" enctype="multipart/form-data">
                                            <div class="input-group input-group"> 
                                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-picture"></i></span>
                                                <input data-toggle="tooltip" name="fotoPresencaEvento" title="Escolha as fotos da presença" type="file" class="form-control" aria-describedby="basic-addon1" required>
                                            </div>

                                            <div class="form-group" id="divBtLogin">
                                                <input type="hidden" name="identificador" value="AdicionaFotoPresencaEvento"> 
                                                <input type="submit" name="adicionarFotoPerfil" class="btn btn-danger btn-md" role="button" value="Adicionar">
                                            </div>
                                        </form>  

                                    </div>
                                    <div class="modal-footer">

                                    </div>

                                </div>
                            </div>
                        </div> 

                    </div>

                </div>
                <div class="list-group-item text-center">Nome: ${evento.nome}</div>
                <div class="list-group-item text-center">Data: ${evento.data}</div>
                <div class="list-group-item text-center">Hora: ${evento.hora}</div>
                <div class="list-group-item text-center">Local: ${evento.local}</div>
                <div class="list-group-item text-center">Descrição: ${evento.descricao}</div>

            </div>
        </div>

    </body>
</html>
