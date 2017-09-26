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
                <div class="col-sm-6 sidenav text-center col-lg-push-1" id="divCentral">
                    <h1>Feed</h1>
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