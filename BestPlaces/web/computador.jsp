<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Computador de Bordo</title>
    </head>
    <body>
        <h1>Resultado do cadastro</h1>
        <form>
            Usuario: <input type="text" value="<%= request.getAttribute("email")%>"/>
            Cadastrado!
            <input value="Retornar" type="submit" onclick="history.back()"/>
        </form>
    </body>
</html>
