<%-- 
    Document   : inicial
    Created on : 17/08/2017, 20:13:14
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
        <title>Página Inicial</title>
    </head>
    <body>
        
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
              <div class="navbar-header">
                <a class="navbar-brand" id="linkMenu" data-toggle="collapse" href="#navbarToggle"><span class="glyphicon glyphicon-home"></span> BestPlaces</a>
              </div>
              <ul class="nav navbar-nav navbar-right">
                <li><a id="linkMenu" href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
              </ul>
            </div>
        </nav>
             
             <div class="collapse" id="navbarToggle">
                 <div class="bg-inverse col-md-12 text-center">
                     <h4>Nome do Usuário</h4>
                     <img id="fotoPerfil" src="Imagens\logo2.png" alt="">
                     <div id="divMenu">
                      <a name="amigos" href="" class="btn btn-danger btn-md btn-block" role="button">Amigos</a>
                      <a name="eventos" href="" class="btn btn-danger btn-md btn-block" role="button">Eventos</a>
                      <a name="locais" href="" class="btn btn-danger btn-md btn-block" role="button">Locais</a>
                      <a name="mensagens" href="" class="btn btn-danger btn-md btn-block" role="button">Mensagens</a>
                     </div>
                 </div>
             </div>
  
          <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
          <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
    </body>
</html>
