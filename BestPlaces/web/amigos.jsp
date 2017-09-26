<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Amigos</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row contant">
                <%@ include file="menu.jsp"%> 
                <div class="col-sm-6" id="divContMen">
                    <div class="row" id="divContMenTit">
                        <div class=" col-md-12 text-center">
                            <h1>Amigos</h1>
                        </div>
                    </div>    

                    <ct:listaAmigos usuarioInteragido="${sessionScope.email}"/>

                    <c:choose>
                        <c:when test="${not empty amigos}">
                            <c:forEach var="amigos" items="${amigos}" >
                                <div class="form-group">
                                    <div id="divResultado">
                                        <img id="fotoAmigo" src="${amigos.fotoPerfil}" alt="FotoPerfil" class="img-circle pull-left">

                                        <div id="divSoliTit" class="form-group pull-left">
                                            <h4>${amigos.nome}</h4> 
                                            <h5 id="hDados">Endereço: ${amigos.cidade}</h5> 
                                            <h5 id="hDados">Profissão: ${amigos.profissao}</h5> 
                                        </div>

                                        <a type="button" onclick="setaDadosModal('${amigos.nome}', '${amigos.email}')" name="buttonModal" data-toggle="modal" id="btPes" class="btn btn-danger btn-md btn" data-target="#myModal" ><i class="glyphicon glyphicon-send"></i></a> 

                                        <script type="text/javascript">
                                            function setaDadosModal(nome, destinatario) {
                                                document.getElementById('nome').value = 'to: ' + nome;
                                                document.getElementById('destinatario').value = destinatario;
                                                document.getElementById('email').value = '<' + destinatario + '>';
                                            }
                                        </script>

                                        <div id="divSoli" class="form-group">
                                            <form action="FrontControl" method="post" id="formDesfazerAmizade">
                                                <input type="hidden" name="identificador" value="GerenciaInteracao">
                                                <input type="hidden" name="usuarioInteragido" value="${amigos.email}"> 
                                                <input type="submit" name="desfazerAmizade" id="btPes" class="btn btn-danger btn-md btn-block" role="button" value="Desfazer Amizade">
                                            </form>

                                        </div>
                                    </div>  
                                </div>

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
                                                    <input name="enviarMensagem" id="sendMenssage" type="submit" class="btn btn-danger" role="button"  value="Enviar">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="form-group">
                                <div class="col-md-12 text-center" id="divResultado">
                                    <h4>Você não possui amigos.</h4>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </body>
</html>