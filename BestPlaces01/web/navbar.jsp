<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\main.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist\css\bootstrap.min.css">
        <title>Navbar</title>
    </head>
    <body>

        <nav class="navbar navbar-inverse" id="navBarNav">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" id="linkMenu" href="inicial.jsp"><span class="glyphicon glyphicon-home"></span> BestPlaces</a>
                </div>
                
                <div class="nav navbar-nav navbar-left" id="divNavPes">
                <form action="pesquisarUsuario.jsp" method="post" name="pesquisarUsuario">   
                    <div class="input-group input-group">
                        <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" name="nome" class="form-control" placeholder="Nome do Usuário" aria-describedby="basic-addon1" required>
                        <div class="input-group-btn">
                            <input type="hidden" name="identificador" value="PesquisarUsuario"> 
                            <button class="btn btn-danger btn-md btn-block" role="button" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </div>
                </form>
                </div>

                <form method="post" action="FrontControl" id="deslogar">
                    <input type="hidden" name="identificador" value="DeslogaSistema">
                    <ul class="nav navbar-nav navbar-right"> 
                        <li role="presentation"><a id="linkMenu" href="solicitacao.jsp"><span class="glyphicon glyphicon-ok"></span> Solicitações <span class="badge">1</span></a></li>
                        <li role="presentation"><a id="linkMenu" href="mensagem.jsp"><span class="glyphicon glyphicon-comment"></span> Mensagens <span class="badge">3</span></a></li>
                        <li><a id="linkMenuLog" href="#" onclick="document.getElementById('deslogar').submit();"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                    </ul>
                </form>

            </div>
        </nav>

        <script src="bootstrap-3.3.7-dist\js\jquery-3.2.1.min.js"></script>
        <script src="bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
    </body>
</html>
