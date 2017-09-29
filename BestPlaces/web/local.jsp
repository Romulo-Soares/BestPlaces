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

                <div class="col-md-2 sidenav pull-right" id="divDadosLo">
                    <a name="cadLocal" href="cadastroLocal.jsp" class="btn btn-danger btn-md btn-block" role="button"><span id="btPerfil" class="glyphicon glyphicon-list-alt"></span> Cadastrar Local</a>
                </div>
                <div class="col-sm-8 sidenav text-center">
                    <ct:listaLocais usuarioLogado="${sessionScope.email}"/>

                    <c:choose>
                        <c:when test="${not empty locais}">
                            <c:forEach var="locais" items="${locais}" >

                                <div class="col-sm-5" id="divLocal">
                                    <img class="img-thumbnail pull-left" src="Imagens\erro.png" alt="Local" id="fotoLocal">
                                    <div class="col-sm-5" id="divDados">  
                                        <h5>${locais.nome}</h5>
                                        <h5>${locais.rua}</h5>
                                        <h5>${locais.cidade}</h5>
                                        <h5>${locais.descricao}</h5>
                                        <h5>${locais.estado}</h5>
                                        <h5>${locais.tipo}</h5>
                                    </div>
                                    <div class="col-sm-12 form-group">
                                        <div class="col-md-4">
                                            <button type="button" name="edLocal" class="btn btn-danger btn-md btn-block" data-toggle="modal" data-target="#modalEditar" role="button"><span class="glyphicon glyphicon-pencil"></span></button>

                                            <div class="modal fade" id="modalEditar" role="dialog">
                                                <div class="modal-dialog modal-md">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                            <h4 class="modal-title">Editar Local</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <form action="FrontControl" method="post" enctype="multipart/form-data">

                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user"></i></span>
                                                                        <input type="text" name="nome" class="form-control" placeholder="Nome" aria-describedby="basic-addon1" value="${locais.nome}" required>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-road"></i></span>
                                                                        <input type="text" name="rua" class="form-control" placeholder="Rua" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-home"></i></span>
                                                                        <input type="text" name="cidade" class="form-control" placeholder="Cidade" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-list-alt"></i></span>
                                                                        <input type="text" name="descricao" class="form-control" placeholder="Descrição" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-flag"></i></span>
                                                                        <input type="text" name="estado" class="form-control" placeholder="Estado" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group">
                                                                    <div class="input-group input-group"> 
                                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-text-size"></i></span>
                                                                        <input type="text" name="tipo" class="form-control" placeholder="Tipo" aria-describedby="basic-addon1" required>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group" id="divBtLogin">
                                                                    <input type="hidden" name="identificador" value="CadastraLocal"> 
                                                                    <input type="submit" name="adicionar" class="btn btn-danger btn-md" role="button" value="Atualizar">
                                                                </div>
                                                            </form>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-4">
                                            <button type="button" onclick="setaDadosModal('${locais.id}', '${locais.nome}')" name="addFotosLugar" class="btn btn-danger btn-md btn-block" data-toggle="modal" data-target="#modalFotos" role="button"><span class="glyphicon glyphicon-picture"></span></button>

                                            <script type="text/javascript">
                                                function setaDadosModal(id, nome) {
                                                    document.getElementById('id').value = id;
                                                    document.getElementById('nome').value = nome;
                                                }
                                            </script>

                                            <div class="modal fade" id="modalFotos" role="dialog">
                                                <div class="modal-dialog modal-md">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                            <h4 class="modal-title">Fotos Local</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <form action="FrontControl" method="post" enctype="multipart/form-data">
                                                                <div class="input-group input-group"> 
                                                                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-picture"></i></span>
                                                                    <input data-toggle="tooltip" name="fotoLocal" title="Escolha a foto do local" type="file" class="form-control" aria-describedby="basic-addon1" required>
                                                                </div>

                                                                <div class="form-group" id="divBtLogin">
                                                                    <input type="hidden" name="id" id="id"> 
                                                                    <input type="hidden" name="nome" id="nome"> 
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

                                        <div class="col-md-4">
                                            <a name="excluirLocal" href="#" class="btn btn-danger btn-md btn-block" role="button"><span class="glyphicon glyphicon-trash"></span></a>   
                                        </div>   
                                    </div>
                                </div>

                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="form-group">
                                <div class="col-md-12 text-center" id="divResultado">
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
