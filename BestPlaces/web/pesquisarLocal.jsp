<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Local</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <ct:findLocalByName nome="${param.nome}"/>
        <div class="container-fluid">
            <%@ include file="menu.jsp"%> 
            <div class="col-sm-6" id="divContMen">
                <div class="row" id="divContMenTit">
                    <div class=" col-md-12 text-center">
                        <h1>Pesquisar Locais</h1>
                    </div>
                </div>
                <div id="divPesLocal">
                <form action="pesquisarLocal.jsp" method="post" name="pesquisarLocal">   
                    <div class="input-group input-group">
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-map-marker"></i></span>
                        <input type="text" name="nome" class="form-control" placeholder="Buscar Local" aria-describedby="basic-addon1" required>
                        <div class="input-group-btn">
                            <input type="hidden" name="identificador" value="PesquisarLocal"> 
                            <button class="btn btn-danger btn-md btn-block" role="button" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </div>
                </form>
                </div>
                <c:if test="${empty locais}">
                    <div class="form-group">
                        <div class="col-md-12 text-center" id="divResultado">
                            <h4>Não encontramos nenhum local :(</h4>
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty locais and not empty param.nome}">
                    <c:forEach var="locais" items="${locais}">
                        <form action="perfilLocal.jsp" method="post" name="perfilLocal">
                            <div class="form-group">
                                <div id="divResultado">
                                    <ct:retornaFotoLocal idLocal="${locais.id}"/>
                                    
                                    <c:if test="${not empty fotoLocal}">
                                    <img id="fotoPesquisa" src="${fotoLocal.foto}" alt="FotoPerfilLocal" class="img-circle pull-left">
                                    </c:if>
                                    
                                    <div id="divPes" class="form-group pull-left">
                                        <h4>${locais.nome}</h4>
                                        <h6 id="hDados">Rua: ${locais.rua}</h6>
                                        <h6 id="hDados">Cidade: ${locais.cidade}</h6>
                                        <h6 id="hDados">Descricao: ${locais.descricao}</h6>
                                        <h6 id="hDados">Estado: ${locais.estado}</h6>
                                        <h6 id="hDados">Tipo: ${locais.tipo}</h6>
                                    </div>
                                    <div id="divPesbt" class="form-group">
                                        <input name="email" type="hidden" value="${locais.usuario}">
                                        <input name="nome" type="hidden" value="${locais.nome}">
                                        <input type="submit" class="btn btn-danger btn-md btn-block" id="btPes" role="button" value="Visualizar Perfil Local"> 
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
