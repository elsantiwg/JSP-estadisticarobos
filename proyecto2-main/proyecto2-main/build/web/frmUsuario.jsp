<%-- 
    Document   : frmUsuario
    Created on : 11/05/2023, 12:39:55 p. m.
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
        <title>Registrar usuario</title>
        <link rel="stylesheet" href="./estilos/estiloFrmciudad.css" />
        <script src="funciones.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <h1>Registrar usuario</h1>
        
        <form action="ControladorInformante" method="post">
            <input type="hidden" name="accion" value="agregar">
            Nombre: <input type="text" name="txtNombre"><br>
            Apellido: <input type="text" name="txtApellido"><br>
            Correo: <input type="text" name="txtCorreo"><br>
            Contraseña: <input type="password" name="hp"><br>
            Telefono: <input type="text" name="txtTelefono"><br>
            <input type="submit" value="Registrar" >
        </form>
        <br>
        <div>
            <% 
                String mensaje= request.getParameter("mensaje");
                if(mensaje!= null){
                    out.print(mensaje);
                }
            %>
        </div>
        
        <a href="index.jsp">home</a>
        
    </body>
</html>