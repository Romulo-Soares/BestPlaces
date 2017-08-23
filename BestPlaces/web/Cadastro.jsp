
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-4.0.0-alpha.6-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-4.0.0-alpha.6-dist\css\bootstrap.min.css">
        <title>Cadastro</title>
    </head>
    <body>
        
        <div class="pos-f-t">
             
             <nav class="navbar navbar-inverse bg-inverse">
             <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
             <span class="navbar-toggler-icon"></span>
             BestPlaces
             </button>
             </nav>
      
         </div>
        
          <div class="container" id="divCad">
            
            <div class="row" id="divCadTit">
                <div class=" col-md-12 text-center">
                    <h1>Cadastro</h1>
                </div>
            </div>
                <form action="controllerCadastro" method="post">
                    <div class="form-group">
                        <input type="text" name="nome" class="form-control" placeholder="Nome" aria-describedby="basic-addon1">
                    </div>

                    <div class="form-group">
                        <input type="text" name="cidade" class="form-control" placeholder="Cidade" aria-describedby="basic-addon1">
                    </div>

                    <div class="form-group">
                        <input type="date" name="nascimento" data-toggle="tooltip" title="Informe sua data de nascimento" class="form-control" placeholder="Nascimento" aria-describedby="basic-addon1">
                    </div>

                    <div class="form-group">
                        <input type="email" name="email" class="form-control" placeholder="Email" aria-describedby="basic-addon1">
                    </div>

                    <div class="form-group">
                        <input type="password" name="senha" class="form-control" placeholder="Senha" aria-describedby="basic-addon1">
                    </div>

                    <div class="form-group">
                        <input type="text" name="profissao" class="form-control" placeholder="Profissão" aria-describedby="basic-addon1">
                    </div>

                    <div class="form-group">
                        <select class="form-control" name="sexo" data-toggle="tooltip" title="Informe seu sexo">
                               <option readonly>Masculino</option>
                               <option>Feminino</option>
                               <option>Outro</option>
                        </select>
                    </div>  

                    <input data-toggle="tooltip" name="foto" title="Escolha sua foto do perfil" type="file" class="form-control" aria-describedby="basic-addon1">

                    <div class="btn-group-justified" id="divBtLogin">
                        <input type="submit" name="cadastrar" class="btn btn-danger btn-xs btn-block" role="button" value="Cadastrar">
                    </div>
                </form>
          </div>
        
          <script src="bootstrap-4.0.0-alpha.6-dist\js\jquery-3.2.1.min.js"></script>
          <script src="bootstrap-4.0.0-alpha.6-dist\js\bootstrap.min.js"></script>
        
    </body>
</html>
