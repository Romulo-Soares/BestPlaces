<%-- 
    Document   : editarPerfil
    Created on : 14/09/2017, 22:04:35
    Author     : Jozimar & Rômulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\bootstrap.min.css">
        <title>Editar Perfil</title>
        <%@ include file="navbar.jsp"%>
    </head>
    <body onload="selecionar('${sessionScope.sexo}')">
    
          <div class="container" id="divCad">
            
            <div class="row" id="divCadTit">
                <div class=" col-md-12 text-center">
                    <h1>Editar Perfil</h1>
                </div>
            </div>
                <form action="FrontControl" method="post">
                    <div class="form-group">
                        <input type="text" name="nome" value="${sessionScope.nome}" class="form-control" placeholder="Nome" aria-describedby="basic-addon1">
                    </div>

                    <div class="form-group">
                        <input type="text" name="cidade" value="${sessionScope.cidade}" class="form-control" placeholder="Cidade" aria-describedby="basic-addon1">
                    </div>

                    <div class="form-group">
                        <input type="date" name="nascimento" value="${sessionScope.nascimento}" data-toggle="tooltip" title="Informe sua data de nascimento" class="form-control" placeholder="Nascimento" aria-describedby="basic-addon1">
                    </div>

                    <div class="form-group">
                        <input type="email" name="email" value="${sessionScope.email}" class="form-control" placeholder="Email" aria-describedby="basic-addon1">
                    </div>

                    <div class="form-group">
                        <input type="password" name="senha" value="${sessionScope.senha}" class="form-control" placeholder="Senha" aria-describedby="basic-addon1">
                    </div>

                    <div class="form-group">
                        <input type="text" name="profissao" value="${sessionScope.profissao}" class="form-control" placeholder="Profissão" aria-describedby="basic-addon1">
                    </div>

                    <div class="form-group">
                       
                        <select class="form-control" name="sexo" id="sexo" data-toggle="tooltip" title="Informe seu sexo">
                               <option value="Masculino">Masculino</option>
                               <option value="Feminino">Feminino</option>
                               <option value="Outro">Outro</option>
                        </select>
                        <script type="text/javascript">
                               function selecionar(uf){
                                    var sexo = document.getElementById("sexo");

                                    for (var i = 0; i < sexo.options.length; i++){
                                        if (sexo.options[i].value == uf){
                                            sexo.options[i].selected = "true";
                                                break;
                                        }
                                    }
                                }
                        </script>
                    </div>  

                    <input data-toggle="tooltip" name="fotoPerfil" value="${sessionScope.foto}" title="Escolha sua foto do perfil" type="file" class="form-control" aria-describedby="basic-addon1">

                    <div class="form-group" id="divBtLogin">
                        <input type="hidden" name="identificador" value="AtualizaUsuario"> 
                        <input type="submit" name="atualizar" class="btn btn-danger btn-md btn-block" role="button" value="Atualizar">
                    </div>
                </form>
          </div>
        
          <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
          <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
        
    </body>
</html>

