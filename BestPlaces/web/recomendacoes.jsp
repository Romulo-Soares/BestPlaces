<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recomendações</title>
        <%@ include file="navbar.jsp"%>

    </head>
    <body>
        <div class="container-fluid">
            <%@ include file="menu.jsp"%> 
            <div class="col-sm-6" id="divContMen">
                <div class="row" id="divContMenTit">
                    <div class=" col-md-12 text-center">
                        <h1>Recomendações</h1>
                    </div>
                </div>

                <ct:listaRecomendacoes usuario="${sessionScope.email}"/>

                <c:choose>
                    <c:when test="${not empty recomendacoes}">
                        <c:forEach var="recomendacoes" items="${recomendacoes}" >
                            <ct:retornaFotoLocal idLocal="${recomendacoes.id}"/>
                            <c:if test="${not empty param.isMarked}">
                                O Local já está marcado para esta data
                            </c:if>

                            <div id="divResultadoRec">
                                <img id="fotoPesquisa" src="${fotoLocal.foto}" alt="FotoPerfilLocal" class="img-circle pull-left">
                                <div id="divPes" class="form-group pull-left">
                                    <h4>${recomendacoes.nome}</h4>
                                    <h6 id="hDados">Rua: ${recomendacoes.rua}</h6>
                                    <h6 id="hDados">Cidade: ${recomendacoes.cidade}</h6>
                                    <h6 id="hDados">Descricao: ${recomendacoes.descricao}</h6>
                                    <h6 id="hDados">Estado: ${recomendacoes.estado}</h6>
                                    <h6 id="hDados">Tipo: ${recomendacoes.tipo}</h6>

                                </div>

                                <ct:countStar idLocal="${recomendacoes.id}"/>


                                <div id="divPesRec" class="form-group pull-right" >
                                    <div class="estrelas  text-center">
                                        <form action="FrontControl" method="post">  
                                            <input type="radio" id="cm_star-empty" name="fb" value="" checked/>
                                            <label for="${recomendacoes.id}-1"><i class="fa"></i></label>
                                            <input type="radio" id="${recomendacoes.id}-1" name="fb" value="1"/>
                                            <label for="${recomendacoes.id}-2"><i class="fa"></i></label>
                                            <input type="radio" id="${recomendacoes.id}-2" name="fb" value="2"/>
                                            <label for="${recomendacoes.id}-3"><i class="fa"></i></label>
                                            <input type="radio" id="${recomendacoes.id}-3" name="fb" value="3"/>
                                            <label for="${recomendacoes.id}-4"><i class="fa"></i></label>
                                            <input type="radio" id="${recomendacoes.id}-4" name="fb" value="4"/>
                                            <label for="${recomendacoes.id}-5"><i class="fa"></i></label>
                                            <input type="radio" id="${recomendacoes.id}-5" name="fb" value="5"/>
                                            <input type="hidden" name="idDoLocal" value="${recomendacoes.id}"> 
                                            <input type="hidden" name="identificador" value="AvaliacaoLocal"> 
                                            <input type="submit" name="avaliarRe" class="btn-sm btn-danger" role="button" value="Avaliar">
                                        </form>    
                                    </div>
                                </div>

                                <script type="text/javascript">
                                    setaDadosStar('${valorAvaliacao}');

                                    function setaDadosStar(valorAvaliacao) {
                                        var radio = document.getElementById("${recomendacoes.id}-" + valorAvaliacao);
                                        radio.checked = "true";
                                    }
                                    ;
                                </script>

                                <div id="divPesbt" class="form-group">

                                    <input type="button" id="btPes" name="marcarPresenca" data-toggle="modal" data-target="#${recomendacoes.id}" class="btn btn-danger btn-md btn-block" role="button" value="Marcar Presença">

                                    <div class="modal fade" id="${recomendacoes.id}" role="dialog">
                                        <div class="modal-dialog">

                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Marcar Presença</h4>
                                                </div>
                                                <form action="FrontControl?identificador=PresencaLocal&id_local=${recomendacoes.id}&nomeLocal=${recomendacoes.nome}" method="post" name="marcar presenca" enctype="multipart/form-data">
                                                    <div class="modal-body">
                                                        <div class="form-group">
                                                            <div class="input-group input-group"> 
                                                                <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-calendar"></i></span>
                                                                <input type="date" name="data" data-toggle="tooltip" title="Informe a data que irá comparecer" class="form-control" placeholder="Nascimento" aria-describedby="basic-addon1" required>
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

                                                        <div class="form-group">
                                                            <div class="input-group input-group"> 
                                                                <input type="button" name="fotosPresencaLocal" data-toggle="modal" data-target="#${recomendacoes.id}-6" class="btn btn-danger btn-md btn-block" role="button" value="Add Fotos">
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button type="submit" class="btn btn-danger" name="btMarcaPresencaRecomendacoes">Marcar Presença</button>
                                                    </div>
                                                </form>

                                            </div>

                                        </div>
                                    </div>
                                </div>

                                <div class="modal fade" id="${recomendacoes.id}-6" role="dialog">
                                    <div class="modal-dialog">
                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                <h4 class="modal-title">Fotos Presença</h4>
                                            </div>

                                            <div class="modal-body">
                                                <form action="FrontControl?fotoPresenca=${recomendacoes.nome}&id=${recomendacoes.id}" method="post" enctype="multipart/form-data">
                                                    <div class="input-group input-group"> 
                                                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-picture"></i></span>
                                                        <input data-toggle="tooltip" name="fotoPresenca" title="Escolha as fotos da presença" type="file" class="form-control" aria-describedby="basic-addon1" required>
                                                    </div>

                                                    <div class="form-group" id="divBtLogin">
                                                        <input type="hidden" name="identificador" value="AdicionaFotoPresencaLocal"> 
                                                        <input type="submit" name="adicionarRec" class="btn btn-danger btn-md" role="button" value="Adicionar">
                                                    </div>
                                                </form>  

                                            </div>
                                            <div class="modal-footer">

                                            </div>

                                        </div>
                                    </div>
                                </div>

                            </div> 
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-12 text-center" id="divResultado">
                            <h4>Você ainda não possui recomendações :(</h4>
                        </div>
                    </c:otherwise>
                </c:choose> 
            </div>
        </div>
    </body>
</html>
