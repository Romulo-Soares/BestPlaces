<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evento</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row contant">
                <%@ include file="menu.jsp"%>
                <div class="col-sm-6" id="divContMen">    
                    <div class="row" id="divContMenTit">
                        <div class=" col-md-12 text-center">
                            <h1>Eventos</h1>
                        </div>
                    </div>
                </div>

                <div class="col-md-2 sidenav pull-right" id="divDadosLo">
                    <a name="cadEvento" href="pesquisarLocalEvento.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-list-alt"></span> Cadastrar Evento</a>
                    <a name="pesEvento" href="pesquisarEvento.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-search"></span> Pesquisar Evento</a>
                </div>
                <div class="col-sm-8 sidenav text-center" id="divLoc">
                    <ct:listaEventos usuarioLogado="${sessionScope.email}"/>

                    <c:choose>
                        <c:when test="${not empty eventos}">
                            <c:forEach var="eventos" items="${eventos}" >

                                <div class="col-sm-5" id="divLocal">
                                    <ct:retornaFotoLocal idLocal="${eventos.idLocal}"/>
                                    <c:choose>
                                        <c:when test="${not empty fotoLocal}">
                                            <img class="img-thumbnail pull-left" src="${fotoLocal.foto}" alt="Local" id="fotoLocal"> 
                                        </c:when>
                                        <c:otherwise>
                                            <img class="img-thumbnail pull-left" src="" alt="Local sem Foto" id="fotoLocal">  
                                        </c:otherwise>        
                                    </c:choose>
                                    <div class="col-sm-5" id="divDados">  
                                        <h5>${eventos.nome}</h5>
                                        <h5>${eventos.data}</h5>
                                        <h5>${eventos.hora}</h5>
                                        <h5>${eventos.local}</h5>
                                        <h5>${eventos.descricao}</h5>
                                    </div>
                                    <div class="col-sm-12 form-group">

                                        <div class="col-md-6">
                                            <button type="button" name="edLocal" class="btn btn-danger btn-md btn-block" data-toggle="modal" data-target="#${eventos.id}" role="button"><span class="glyphicon glyphicon-pencil"></span></button>

                                            <div class="modal fade" id="${eventos.id}" role="dialog">
                                                <div class="modal-dialog modal-md">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                            <h4 class="modal-title">Editar Evento</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <form action="FrontControl" method="post" enctype="multipart/form-data">

                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-globe"></i></span>
                                                                        <input type="text" name="nome" value="${eventos.nome}" class="form-control" placeholder="Nome" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-calendar"></i></span>
                                                                        <input type="date" name="data" value="${eventos.data}" data-toggle="tooltip" title="Informe a data do evento" class="form-control" placeholder="Data" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-time"></i></span>
                                                                        <input type="time" name="hora" value="${eventos.hora}" data-toggle="tooltip" title="Informe a hora do evento" class="form-control" placeholder="Hora" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-list-alt"></i></span>
                                                                        <input type="text" name="descricao" value="${eventos.descricao}" class="form-control" placeholder="Descrição" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group" id="divBtLogin">
                                                                    <input type="hidden" name="id" value="${eventos.id}"> 
                                                                    <input type="hidden" name="identificador" value="AtualizaEvento"> 
                                                                    <input type="submit" name="atualizar" class="btn btn-danger btn-md" role="button" value="Atualizar">
                                                                </div>
                                                            </form>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <form method="post" action="FrontControl?idEvento=${eventos.id}">
                                                <input type="hidden" name="identificador" value="ExcluiEvento">
                                                <input type="submit" name="excluirEvento" class="btn btn-danger btn-md btn-block" value="Excluir">
                                            </form>
                                        </div>   

                                        <div class="col-md-6" id="divEven">        
                                            <form action="FrontControl" method="post" name="divulgarEvento">
                                                <input type="hidden" name="identificador" value="DivulgaEvento">
                                                <input type="hidden" name="idEvento" value="${eventos.id}">
                                                <ct:eventoDivulgado idEvento="${eventos.id}" usuario="${sessionScope.email}"/>
                                                <c:choose>
                                                    <c:when test="${divulgado == false}">
                                                        <input type="submit" name="divulgarE" class="btn btn-danger btn-md btn-block" role="button" value="Divulgar">
                                                    </c:when>
                                                    <c:otherwise>
                                                        Evento Divulgado
                                                        <input type="submit" name="desfazerDivulgacaoE" class="btn btn-danger btn-md btn-block" role="button" value="Desfazer">
                                                    </c:otherwise>
                                                </c:choose>
                                            </form>
                                        </div>  

                                        <div class="col-md-6" id="divEven">  
                                            <c:if test="${not empty param.isMarked}">
                                                O Evento já está marcado para esta data
                                            </c:if>          

                                            <input type="button" id="btMarcar" name="marcarPresenca" data-toggle="modal" data-target="#${eventos.id}-1" class="btn btn-danger btn-md" role="button" value="Marcar Presença">

                                            <div class="modal fade" id="${eventos.id}-1" role="dialog">
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

                                                                <ct:verificaPresencaEvento idEvento="${eventos.id}" usuario="${sessionScope.email}"/>
                                                                <c:if test="${presenciado == true}" >
                                                                    <div class="form-group">
                                                                        <div class="input-group input-group"> 
                                                                            <input type="button" name="fotosPresencaEvento" data-toggle="modal" data-target="#${eventos.id}-2" class="btn btn-danger btn-md btn-block" role="button" value="Add Fotos">
                                                                        </div>
                                                                    </div>
                                                                </c:if>

                                                            </div>
                                                            <div class="modal-footer">
                                                                <input type="hidden" name="identificador" value="PresencaEvento">
                                                                <input type="hidden" name="idEvento" value="${eventos.id}">
                                                                <input type="hidden" name="nome" value="${eventos.nome}">
                                                                <button type="submit" name="mpE" class="btn btn-danger">Marcar Presença</button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="modal fade" id="${eventos.id}-2" role="dialog">
                                            <div class="modal-dialog">
                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title">Fotos Presença</h4>
                                                    </div>

                                                    <div class="modal-body">
                                                        <form action="FrontControl?fotoPresencaEvento=${eventos.nome}&id=${eventos.id}" method="post" enctype="multipart/form-data">
                                                            <div class="input-group input-group"> 
                                                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-picture"></i></span>
                                                                <input data-toggle="tooltip" name="fotoPresencaEvento" title="Escolha as fotos da presença" type="file" class="form-control" aria-describedby="basic-addon1" required>
                                                            </div>

                                                            <div class="form-group" id="divBtLogin">
                                                                <input type="hidden" name="identificador" value="AdicionaFotoPresencaEvento"> 
                                                                <input type="submit" name="adicionar" class="btn btn-danger btn-md" role="button" value="Adicionar">
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

                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="form-group">
                                <div class="col-md-8 col-md-push-2 text-center" id="divResultado">
                                    <h4>Você não possui eventos</h4>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>

    </body>
</html>