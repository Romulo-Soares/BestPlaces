<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row contant">
                <%@ include file="menu.jsp"%>
                <ct:listaRecomendacoes usuario="${sessionScope.email}"/>
                <div class="col-sm-6 sidenav text-center col-lg-push-1" id="divCentral">

                    <c:choose>
                        <c:when test="${not empty recomendacoes}">
                            <c:forEach var="recomendacoes" items="${recomendacoes}" >
                                <ct:retornaFotoLocal idLocal="${recomendacoes.id}"/>
                                <div class="" id="divResultadoFeed">
                                    <img id="fotoPesquisa" src="${fotoLocal.foto}" alt="FotoPerfilLocal" class="img-circle pull-left">
                                    <div id="divPes" class="form-group pull-left">
                                        <h4>${recomendacoes.nome}</h4>
                                        <h6 id="hDados">Rua: ${recomendacoes.rua}</h6>
                                        <h6 id="hDados">Cidade: ${recomendacoes.cidade}</h6>
                                        <h6 id="hDados">Descricao: ${recomendacoes.descricao}</h6>
                                        <h6 id="hDados">Estado: ${recomendacoes.estado}</h6>
                                        <h6 id="hDados">Tipo: ${recomendacoes.tipo}</h6>

                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="col-md-12 text-center" id="divResultado">
                                <h4>Suas recomendações e divulgações aparecerão Aqui</h4>
                            </div>
                        </c:otherwise>
                    </c:choose>

                </div>

                <ct:dezMaisConversadores usuarioInteragido="${sessionScope.email}"/>
                <c:choose>
                    <c:when test="${not empty dezMaisConversadores}">
                        <div class="col-sm-2 sidenav pull-right" id="divDadosLo">
                            <c:forEach var="dezMais" items="${dezMaisConversadores}">  
                                <div class="well">
                                    <p>${dezMais.nome}</p>
                                </div> 
                            </c:forEach>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-sm-2 sidenav pull-right" id="divDadosLo">
                            <div class="well">
                                <p>Nenhum amigo encontrado!</p>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>

            </div>

        </div>

    </body>
</html>