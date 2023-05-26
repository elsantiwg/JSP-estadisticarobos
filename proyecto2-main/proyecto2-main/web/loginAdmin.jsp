<%-- 
    Document   : loginAdmin
    Created on : 12/05/2023, 2:06:56 p. m.
    Author     : juan
--%>
<%@page import="controlador.*" %>
<%@page import="modelo.*" %>
<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesión</title>
    </head>
    <body>
        <form action="ControladorAdministrador" method="get">
            <input type="hidden" name="accion" value="verificar">
            Correo: <input type="text" name="txtCorreo"><br>
            Contraseña: <input type="password" name="clave"><br>
            <input type="submit" value="Registrar" >
        </form>
        <a href="index.jsp">home</a><br>
        
        <% 
            String mensaje= request.getParameter("mensaje");
            if(mensaje!= null){
                out.print(mensaje);
            }
        %>
    </body>
</html>