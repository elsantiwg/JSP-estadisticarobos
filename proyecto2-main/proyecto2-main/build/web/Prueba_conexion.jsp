<%-- 
    Document   : Prueba_conexion
    Created on : 1 may. 2023, 20:41:57
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*" %>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
        
            String mensaje="<br><b>Prueba de conexion a la base de datos </b>";
            out.print(mensaje);
            Conexion.getConexion();
            out.print("<br>"+Conexion.getMensaje());
            
        
        %>
        
        
        <a href="index.jsp">home</a>
    </body>
</html>
