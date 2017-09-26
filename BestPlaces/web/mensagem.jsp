<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensagens</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container" id="divCad">

            <div class="row" id="divCadTit">
                <div class=" col-md-12 text-center">
                    <h1>Mensagens</h1>
                </div>
            </div>

            <ct:findUserMensseger destinatario="${sessionScope.email}"/>

            <c:choose>
                <c:when test="${not empty mensageiros}">
                    <c:forEach var="mensageiros" items="${mensageiros}" >

                        <ct:findMessages remetente="${mensageiros.email}" destinatario="${sessionScope.email}"/>

                        <c:forEach var="mensagens" items="${mensagens}" >                      
                            <c:set var="msg" value="${msg}<${mensagens.remetente}>: ${mensagens.mensagem}\n" />
                        </c:forEach>

                        <div class="form-group">
                            <div id="divResultadoMens">
                                <img id="fotoPesquisa" src="${mensageiros.fotoPerfil}" alt="FotoPerfil" class="img-circle pull-left">
                                <div id="divPes" class="form-group pull-left">
                                    <h4>${mensageiros.nome}</h4>

                                    <a type="button" onclick="setaDadosModal('${mensageiros.nome}', '${mensageiros.email}', '${msg}')" class="btn btn-danger btn-md" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-send"></i> Responder</a>

                                    <script type="text/javascript">
                                        function setaDadosModal(nome, destinatario, mensagens) {
                                            document.getElementById('nome').value = 'to: ' + nome;
                                            document.getElementById('destinatario').value = destinatario;
                                            document.getElementById('email').value = '<' + destinatario + '>';
                                            document.getElementById('mensagensRecebidas').value = mensagens;
                                        }
                                    </script>

                                    <!-- Modal Envio Mensagem-->
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

                                                        <div id="divMens">
                                                            <div class="modal-body">
                                                                <textarea name="mensagensRecebidas" id="mensagensRecebidas" readonly="true" class="form-control" cols="8" rows="4"></textarea>
                                                                <br><textarea name="mensagem" placeholder="Escreva sua mensagem de texto aqui ..." class="form-control" cols="10" rows="2"></textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="submit" name="respostaMensagem" class="btn btn-danger" role="button">Enviar</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div><!-- Fim modal -->
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="form-group">
                        <div class="col-md-12 text-center" id="divResultado">
                            <h4>Você não possui mensagens.</h4>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>

    </body>
</html>
