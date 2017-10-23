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

                            <ct:buscaUsuarioRecomendador idLocal="${recomendacoes.id}" usuarioDestino="${sessionScope.email}"/>

                            <div class="text-center">
                                <b>${usuarioRecomendador}</b><em> recomendou este local para você</em>
                            </div>

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
                            <ct:buscaUsuarioDivulgador idEvento="${ed.id}"/>

                            <div class="text-center">
                                <b>${usuarioDivulgador}</b><em> divulgou este evento</em>
                            </div>

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

                    <ct:listaLocaisPresenciados usuario="${sessionScope.email}"/>
                    <c:forEach var="lp" items="${locaisPresenciados}">
                        <ct:retornaFotoLocal idLocal="${lp.idLocal}"/>

                        <div class="text-center">
                            <ct:findUserProfile email="${lp.usuarioPresenciador}"/>
                            <em><b>${usuario.nome}</b> marcou presenca neste local em ${lp.dataPresenca}</em><br>
                            com status: ${lp.statusPresenciador} e comentário: ${lp.comentarioPresenciador}
                        </div>

                        <div class="" id="divResultadoFeed">
                            <img id="fotoPesquisa" src="${fotoLocal.foto}" alt="FotoPerfilLocal" class="img-circle pull-left">

                            <div id="divPes" class="form-group pull-left">
                                <h4>${lp.nomeLocal}</h4>
                                <h6 id="hDados">Rua: ${lp.ruaLocal}</h6>
                                <h6 id="hDados">Cidade: ${lp.cidadeLocal}</h6>
                                <h6 id="hDados">Descricao: ${lp.descricaoLocal}</h6>
                                <h6 id="hDados">Estado: ${lp.estadoLocal}</h6>
                                <h6 id="hDados">Tipo: ${lp.tipoLocal}</h6>
                            </div>
                        </div>
                    </c:forEach>

                    <ct:listaEventosPresenciados usuario="${sessionScope.email}"/>
                    <c:forEach var="ep" items="${eventosPresenciados}">
                        <ct:retornaFotoLocal idLocal="${ep.evento.idLocal}"/>
                        
                        <div class="text-center">
                            <ct:findUserProfile email="${ep.presencaEvento.usuario}"/>
                            <em><b>${usuario.nome}</b> marcou presenca neste evento em ${ep.presencaEvento.data}</em><br>
                            com status: ${ep.presencaEvento.status} e comentário: ${ep.presencaEvento.comentario}
                        </div>
                        
                        <div class="" id="divResultadoFeed">
                            <img id="fotoPesquisa" src="${fotoLocal.foto}" alt="FotoPerfilLocal" class="img-circle pull-left">
                            <div id="divPes" class="form-group pull-left">
                                <h4>${ep.evento.nome}</h4>
                                <h6 id="hDados">Criado por: ${ep.evento.usuario}</h6>
                                <h6 id="hDados">Cidade: ${ep.evento.data}</h6>
                                <h6 id="hDados">Descricao: ${ep.evento.hora}</h6>
                                <h6 id="hDados">Estado: ${ep.evento.local}</h6>
                                <h6 id="hDados">Tipo: ${ep.evento.descricao}</h6>
                            </div>
                        </div>

                    </c:forEach>


                    <c:if test="${empty eventosDivulgados and empty recomendacoes 
                                  and empty eventosPresenciados and empty locaisPresenciados}">
                        <div class="col-md-12 text-center" id="divResultado">
                            <h5>Suas recomendações, divulgações e marcações em eventos e locais de amigos aparecerão Aqui</h5>
                        </div>
                    </c:if>

                </div>

                <ct:dezMaisConversadores usuarioInteragido="${sessionScope.email}"/>
                <div class="col-sm-2 sidenav pull-right" id="divMenuDez">
                  <h5 class="text-center">Dez Mais Conversadores</h5>  
                </div>
                
                <c:choose>
                    <c:when test="${not empty dezMaisConversadores}">
                        <div class="col-sm-2 sidenav pull-right" id="divMenuLa">
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
                        <div class="col-sm-2 sidenav pull-right" id="divMenuLa">
                            <div class="well-sm text-center" id="divWell">
                                <p>Nenhum amigo encontrado!</p>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>

            </div>

        </div>

    </body>
</html>