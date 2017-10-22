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

                    <ct:listaRecomendacoes usuario="${sessionScope.email}"/>

                    <c:if test="${not empty recomendacoes}">
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
                    </c:if>

                    <ct:listaEventosDivulgados usuario="${sessionScope.email}"/>

                    <c:if test="${not empty eventosDivulgados}">
                        <c:forEach var="ed" items="${eventosDivulgados}" >
                            <ct:retornaFotoLocal idLocal="${ed.idLocal}"/>
                            <div class="" id="divResultadoFeed">
                                <img id="fotoPesquisa" src="${fotoLocal.foto}" alt="FotoPerfilLocal" class="img-circle pull-left">
                                <div id="divPes" class="form-group pull-left">
                                    <h4>${ed.nome}</h4>
                                    <h6 id="hDados">Criado por: ${ed.usuario}</h6>
                                    <h6 id="hDados">Cidade: ${ed.data}</h6>
                                    <h6 id="hDados">Descricao: ${ed.hora}</h6>
                                    <h6 id="hDados">Estado: ${ed.local}</h6>
                                    <h6 id="hDados">Tipo: ${ed.descricao}</h6>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>

                    <c:if test="${eventosDivulgados eq null and recomendacoes eq null}">
                        <div class="col-md-12 text-center" id="divResultado">
                            <h4>Suas recomendações e divulgações aparecerão Aqui</h4>
                        </div>
                    </c:if>

                </div>

                <ct:dezMaisConversadores usuarioInteragido="${sessionScope.email}"/>

                <c:choose>
                    <c:when test="${not empty dezMaisConversadores}">
                        <div class="col-sm-2 sidenav pull-right" id="divMenuLa">
                            <h5 class="text-center">Dez Mais Conversadores</h5>
                            <c:forEach var="dezMais" items="${dezMaisConversadores}">  
                                <div class="well-sm text-center" id="divWell">
                                    <a type="button" onclick="setaDadosModal('${dezMais.nome}', '${dezMais.email}')" data-toggle="modal" id="btPes" class="btn btn-md" data-target="#myModal" >${dezMais.nome}</a>
                                </div> 

                                <script type="text/javascript">
                                    function setaDadosModal(nome, destinatario) {
                                        document.getElementById('nome').value = 'to: ' + nome;
                                        document.getElementById('destinatario').value = destinatario;
                                        document.getElementById('email').value = '<' + destinatario + '>';
                                    }
                                </script>
                                
                                <!--Modal Send Message-->
                                <div class="modal fade" id="myModal" role="dialog">
                                    <div class="modal-dialog modal-md">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <input class="modal-title" id="nome" readonly="true" name="nome">
                                                <input id="email" readonly="true" name="email">
                                            </div>
                                            <form action="FrontControl" method="post" id="formMensagem">
                                                <input type="hidden" name="identificador" value="Mensagem">
                                                <input id="destinatario" type="hidden" name="destinatario">
                                                <div class="modal-body">
                                                    <textarea placeholder="Escreva sua mensagem de texto aqui ..." name="mensagem" class="form-control" cols="10" rows="4"></textarea>
                                                </div>
                                                <div class="modal-footer">
                                                    <input name="enviarMensagemI" id="sendMenssage" type="submit" class="btn btn-danger" role="button"  value="Enviar">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
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