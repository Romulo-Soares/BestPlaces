<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <div class="col-sm-8 sidenav text-center" id="divCentral">
                    <h1>Feed</h1>
                </div>

                <div class="col-sm-2 sidenav pull-right" id="divDadosLo">
                    <div class="well">
                        <p>Amigo 1</p>
                    </div>
                    <div class="well">
                        <p>Amigo 2</p>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>