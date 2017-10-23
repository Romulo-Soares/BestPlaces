<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Local</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row contant">
                <%@ include file="menu.jsp"%>
                <div class="col-sm-6" id="divContMen">    
                    <div class="row" id="divContMenTit">
                        <div class=" col-md-12 text-center">
                            <h1>Locais</h1>
                        </div>
                    </div>
                </div>

                <div class="col-sm-2 sidenav pull-right" id="divDadosLo">
                    <a name="cadLocal" href="cadastroLocal.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-list-alt"></span> Cadastrar Local</a>
                    <a name="pesLocal" href="pesquisarLocal.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-search"></span> Pesquisar Local</a>
                    <a name="recomendacao" href="recomendacoes.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-share"></span> Recomendações</a>
                </div>

                <div class="col-sm-8 sidenav text-center" id="divLoc">
                    <ct:listaLocais usuarioLogado="${sessionScope.email}"/>

                    <c:choose>
                        <c:when test="${not empty locais}">
                            <c:forEach var="locais" items="${locais}" >

                                <div class="col-sm-5" id="divLocal">
                                    <ct:retornaFotoLocal idLocal="${locais.id}"/>
                                    <c:choose>
                                        <c:when test="${not empty fotoLocal}">
                                            <img class="img-thumbnail pull-left" src="${fotoLocal.foto}" alt="Local" id="fotoLocal"> 
                                        </c:when>
                                        <c:otherwise>
                                            <img class="img-thumbnail pull-left" src="" alt="Add uma Foto" id="fotoLocal">  
                                        </c:otherwise>        
                                    </c:choose>
                                    <div class="col-sm-5" id="divDados">  
                                        <h5>${locais.nome}</h5>
                                        <h5>${locais.rua}</h5>
                                        <h5>${locais.cidade}</h5>
                                        <h5>${locais.descricao}</h5>
                                        <h5>${locais.estado}</h5>
                                        <h5>${locais.tipo}</h5>
                                    </div>
                                    <div class="col-sm-12 form-group">

                                        <div class="col-md-6">
                                            <button type="button" name="addFotosLugar" class="btn btn-danger btn-md btn-block" data-toggle="modal" data-target="#${locais.id}" role="button"><span class="glyphicon glyphicon-picture"></span></button>

                                            <div class="modal fade" id="${locais.id}" role="dialog">
                                                <div class="modal-dialog modal-md">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                            <h4 class="modal-title">Fotos Local</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <form action="FrontControl?foto=${locais.nome}&id=${locais.id}" method="post" enctype="multipart/form-data">
                                                                <div class="input-group input-group"> 
                                                                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-picture"></i></span>
                                                                    <input data-toggle="tooltip" name="fotoLocal" title="Escolha a foto do local" type="file" class="form-control" aria-describedby="basic-addon1" required>
                                                                </div>

                                                                <div class="form-group" id="divBtLogin">
                                                                    <input type="hidden" name="identificador" value="AdicionaFotoLocal"> 
                                                                    <input type="submit" name="adicionar" class="btn btn-danger btn-md" role="button" value="Adicionar">
                                                                </div>
                                                            </form>

                                                        </div>
                                                        <div class="modal-footer">

                                                            <ct:listaFotosLocal idFoto="${locais.id}"/>

                                                            <c:choose>
                                                                <c:when test="${not empty fotosLocal}">
                                                                    <c:forEach var="fotosLocal" items="${fotosLocal}" >

                                                                        <div class="col-sm-6 sidenav text-center" id="divGaleria">
                                                                            <img class="img-thumbnail" src="${fotosLocal.foto}" alt="Local">
                                                                        </div>
                                                                    </c:forEach>
                                                                </c:when>
                                                            </c:choose>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <form method="post" action="FrontControl?idLocal=${locais.id}&localNome=${locais.nome}">
                                                <input type="hidden" name="identificador" value="ExcluiLocal">
                                                <input type="submit" name="excluirLocal" class="btn btn-danger btn-md btn-block" value="Excluir">
                                            </form>
                                        </div>


                                        <div class="col-md-6" id="divEven">

                                            <c:if test="${not empty param.isRecommended}">
                                                O Usuario já está recomendado para este local
                                            </c:if>

                                            <input type="button" name="recomendar" data-toggle="modal" data-target="#${locais.id}-1" class="btn btn-danger btn-md btn-block" role="button" value="Recomendar">

                                            <div class="modal fade" id="${locais.id}-1" role="dialog">
                                                <div class="modal-dialog">
                                                    <form action="FrontControl?identificador=RecomendaLocal&id_local=${locais.id}&nomeLocal=${param.nome}" method="post" name="recomendacaoLocal">
                                                        <!-- Modal content-->
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                <h4 class="modal-title">Recomendar</h4>
                                                            </div>
                                                            <div class="modal-body">
                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user"></i></span>
                                                                        <input type="email" name="usuario_destino" class="form-control" placeholder="Email do amigo" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <input type="hidden" name="email" value="${locais.usuario}"> 
                                                                <button type="submit" name="recomendarPageLocal" class="btn btn-danger" >Recomendar</button>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-6" id="divEven">
                                            <c:if test="${not empty param.isMarked}">
                                                O Local já está marcado para esta data
                                            </c:if>  

                                            <input type="button" id="btMarcar" name="marcarPresenca" data-toggle="modal" data-target="#${locais.id}-2" class="btn btn-danger btn-md btn-block" role="button" value="Marcar Presença">

                                            <div class="modal fade" id="${locais.id}-2" role="dialog">
                                                <div class="modal-dialog">
                                                    <!-- Modal content-->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                            <h4 class="modal-title">Marcar Presença</h4>
                                                        </div>
                                                        <form action="FrontControl?identificador=PresencaLocal&id_local=${locais.id}&nomeLocal=${param.nome}" method="post" name="marcar presenca" enctype="multipart/form-data">
                                                            <div class="modal-body">
                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-calendar"></i></span>
                                                                        <input type="date" name="data" data-toggle="tooltip" title="Informe a data que irá comparecer" class="form-control" placeholder="Comparecimento" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-check"></i></span>
                                                                        <input type="text" name="status" class="form-control" placeholder="Status" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-comment"></i></span>
                                                                        <input type="text" name="comentario" class="form-control" placeholder="Comentário" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>

                                                                <div class="input-group input-group"> 
                                                                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-picture"></i></span>
                                                                    <input data-toggle="tooltip" name="foto" title="Escolha a foto da presença" type="file" class="form-control" aria-describedby="basic-addon1" required>
                                                                </div><br>

                                                                <ct:verificaPresencaLocal idLocal="${locais.id}" usuario="${sessionScope.email}"/>
                                                                <c:if test="${presenciado == true}" >
                                                                    <div class="form-group">
                                                                        <div class="input-group input-group"> 
                                                                            <input type="button" name="fotosPresencaLocal" data-toggle="modal" data-target="#${locais.id}-3" class="btn btn-danger btn-md btn-block" role="button" value="Add Fotos">
                                                                        </div>
                                                                    </div>
                                                                </c:if>

                                                            </div>
                                                            <div class="modal-footer">
                                                                <input type="hidden" name="email" value="${locais.usuario}"> 
                                                                <button type="submit" name="marcarPresencaPageLocal" class="btn btn-danger">Marcar Presença</button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="modal fade" id="${locais.id}-3" role="dialog">
                                                <div class="modal-dialog">
                                                    <!-- Modal content-->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                            <h4 class="modal-title">Fotos Presença</h4>
                                                        </div>

                                                        <div class="modal-body">
                                                            <form action="FrontControl?fotoPresenca=${locais.nome}&id=${locais.id}" method="post" enctype="multipart/form-data">
                                                                <div class="input-group input-group"> 
                                                                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-picture"></i></span>
                                                                    <input data-toggle="tooltip" name="fotoPresenca" title="Escolha as fotos da presença" type="file" class="form-control" aria-describedby="basic-addon1" required>
                                                                </div>

                                                                <div class="form-group" id="divBtLogin">
                                                                    <input type="hidden" name="identificador" value="AdicionaFotoPresencaLocal"> 
                                                                    <input type="submit" name="adicionar" class="btn btn-danger btn-md" role="button" value="Adicionar">
                                                                </div>
                                                            </form>  

                                                        </div>
                                                        <div class="modal-footer">

                                                        </div>

                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="form-group">
                                <div class="col-md-8 col-md-push-2 text-center" id="divResultado">
                                    <h4>Você não possui locais</h4>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>

    </body>
</html>