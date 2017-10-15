<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Eventos</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <ct:findEventoByName nome="${param.nome}"/>
        <div class="container-fluid">
            <div id="divContPes">
                <div class="row" id="divContMenTit">
                    <div class=" col-md-12 text-center">
                        <h1>Pesquisar Eventos</h1>
                    </div>
                </div>
                <div id="divPesLocal">
                <form action="pesquisarEvento.jsp" method="post" name="pesquisarEvento">   
                    <div class="input-group input-group">
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-map-marker"></i></span>
                        <input type="text" name="nome" class="form-control" placeholder="Buscar Evento" aria-describedby="basic-addon1" required>
                        <div class="input-group-btn">
                            <input type="hidden" name="identificador" value="PesquisarEvento"> 
                            <button class="btn btn-danger btn-md btn-block" role="button" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </div>
                </form>
                </div>
                <c:if test="${empty eventos}">
                    <div class="form-group">
                        <div class="col-md-12 text-center" id="divResultado">
                            <h4>Não encontramos nenhum evento :(</h4>
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty eventos and not empty param.nome}">
                    <c:forEach var="eventos" items="${eventos}">
                        <form action="perfilEvento.jsp" method="post" name="perfilEvento">
                            <div class="form-group">
                                <div id="divResultado">
                                    <ct:retornaFotoLocal idLocal="${eventos.idLocal}"/>
                                    
                                    <c:if test="${not empty fotoLocal}">
                                    <img id="fotoPesquisa" src="${fotoLocal.foto}" alt="FotoPerfilLocal" class="img-circle pull-left">
                                    </c:if>
                                    
                                    <div id="divPes" class="form-group pull-left">
                                        <h4>${eventos.nome}</h4>
                                        <h6 id="hDados">Data: ${eventos.data}</h6>
                                        <h6 id="hDados">Hora: ${eventos.hora}</h6>
                                        <h6 id="hDados">Local: ${eventos.local}</h6>
                                        <h6 id="hDados">Descrição: ${eventos.descricao}</h6>
                                    </div>
                                    <div id="divPesbt" class="form-group">
                                        <input name="email" type="hidden" value="${eventos.usuario}">
                                        <input name="nome" type="hidden" value="${eventos.nome}">
                                        <input type="submit" class="btn btn-danger btn-md btn-block" id="btPes" role="button" value="Visualizar Perfil Evento"> 
                                    </div>
                                </div>  
                            </div>
                        </form>
                    </c:forEach>
                </c:if>   
            </div>
        </div>
    </body>
</html>
