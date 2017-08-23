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
         <link rel="stylesheet" href="bootstrap-4.0.0-alpha.6-dist\css\main.css">
         <link rel="stylesheet" href="bootstrap-4.0.0-alpha.6-dist\css\bootstrap.min.css">
        <title>Página Inicial</title>
    </head>
    <body>
        
         <div class="pos-f-t">
             
             <nav class="navbar navbar-inverse bg-inverse">
             <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
             <span class="navbar-toggler-icon"></span>
             BestPlaces
             </button>
             </nav>
             
             <div class="collapse" id="navbarToggleExternalContent">
                 <div class="bg-inverse col-md-12 text-center">
                     <h4 class="text-white">Nome do Usuário</h4>
                     <img id="fotoPerfil" src="Imagens\logo2.png" alt="">
                     <div id="divLogout">
                      <a name="amigos" href="" class="btn btn-danger btn-xs btn-block" role="button">Amigos</a>
                      <a name="eventos" href="" class="btn btn-danger btn-xs btn-block" role="button">Eventos</a>
                      <a name="locais" href="" class="btn btn-danger btn-xs btn-block" role="button">Locais</a>
                      <a name="mensagens" href="" class="btn btn-danger btn-xs btn-block" role="button">Mensagens</a>
                      <a name="logout" href="" class="btn btn-danger btn-xs btn-block" role="button">Logout</a>
                     </div>
                 </div>
             </div>
         </div>
          <script src="bootstrap-4.0.0-alpha.6-dist\js\jquery-3.2.1.min.js"></script>
          <script src="bootstrap-4.0.0-alpha.6-dist\js\bootstrap.min.js"></script>
    </body>
</html>
