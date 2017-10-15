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
                <div class="col-sm-8 sidenav text-center">
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
                                    </div>
                                </div>

                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="form-group">
                                <div class="col-md-12 text-center" id="divResultado">
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