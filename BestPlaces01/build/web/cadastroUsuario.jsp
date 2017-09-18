
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\bootstrap.min.css">
        <title>Cadastro</title>
    </head>
    <body>
        
       <nav class="navbar navbar-inverse" id="navBarNav">
            <div class="container-fluid">
              <div class="navbar-header">
                  <a class="navbar-brand" id="linkMenu" href="index.jsp"><span class="glyphicon glyphicon-list-alt"></span> BestPlaces</a>
              </div>
            </div>
        </nav>
        
          <div class="container" id="divCad">
            
            <div class="row" id="divCadTit">
                <div class=" col-md-12 text-center">
                    <h1>Cadastro</h1>
                </div>
            </div>
                <form action="FrontControl" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="text" name="nome" class="form-control" placeholder="Nome" aria-describedby="basic-addon1" required>
                    </div>

                    <div class="form-group">
                        <input type="text" name="cidade" class="form-control" placeholder="Cidade" aria-describedby="basic-addon1" required>
                    </div>

                    <div class="form-group">
                        <input type="date" name="nascimento" data-toggle="tooltip" title="Informe sua data de nascimento" class="form-control" placeholder="Nascimento" aria-describedby="basic-addon1" required>
                    </div>

                    <div class="form-group">
                        <input type="email" name="email" class="form-control" placeholder="Email" aria-describedby="basic-addon1" required>
                    </div>

                    <div class="form-group">
                        <input type="password" name="senha" class="form-control" placeholder="Senha" aria-describedby="basic-addon1" required>
                    </div>

                    <div class="form-group">
                        <input type="text" name="profissao" class="form-control" placeholder="Profissão" aria-describedby="basic-addon1" required>
                    </div>

                    <div class="form-group">
                        <select class="form-control" name="sexo" data-toggle="tooltip" title="Informe seu sexo" required>
                               <option readonly>Masculino</option>
                               <option>Feminino</option>
                               <option>Outro</option>
                        </select>
                    </div>  

                    <input data-toggle="tooltip" name="fotoPerfil" title="Escolha sua foto do perfil" type="file" class="form-control" aria-describedby="basic-addon1" required>

                    <div class="form-group" id="divBtLogin">
                        <input type="hidden" name="identificador" value="CadastroUsuario"> 
                        <input type="submit" name="cadastrar" class="btn btn-danger btn-md btn-block" role="button" value="Cadastrar">
                    </div>
                </form>
          </div>
        
          <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
          <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
        
    </body>
</html>