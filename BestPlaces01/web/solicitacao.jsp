<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitação</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container" id="divCad">
            <div class="row" id="divCadTit">
                <div class=" col-md-12 text-center">
                    <h1>Solicitações</h1>
                </div>
            </div>    

            <ct:buscaSolicitacoes usuarioInteragido="${sessionScope.email}"/>

            <c:choose>
                <c:when test="${not empty solicitacoes}">
                    <c:forEach var="solicitacao" items="${solicitacoes}">
                        <div class="form-group">
                            <div id="divResultado">
                                <img id="fotoAmigo" src="${solicitacao.fotoPerfil}" alt="FotoPerfil" class="img-circle">

                                <div id="divSoliTit" class="form-group">
                                    <h4>${solicitacao.nome}</h4>
                                    <h5 id="hDados">Cidade: ${solicitacao.cidade}</h5>
                                    <h5 id="hDados">Profissão: ${solicitacao.profissao}</h5>
                                </div>
                                <form action="FrontControl" method="post">
                                    <input type="hidden" name="identificador" value="GerenciaInteracao">
                                    <input type="hidden" name="usuarioInteragido" value="${solicitacao.email}">
                                    <div id="divSoli" class="form-group">
                                        <input type="submit" name="aceitarConvite" class="btn btn-danger btn-md btn-block" role="button" value="Aceitar Convite"> 
                                        <input type="submit" name="rejeitarConvite" class="btn btn-danger btn-md btn-block" role="button" value="Rejeitar Convite">  
                                    </div>
                                </form>
                            </div>  
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="form-group">
                        <div class="col-md-12 text-center" id="divResultado">
                            <h4>Você não têm novas solicitações no momento :(</h4>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
    </body>
</html>
