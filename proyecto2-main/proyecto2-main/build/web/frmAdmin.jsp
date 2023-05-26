<%-- 
    Document   : frmAdmin
    Created on : 12/05/2023, 3:19:24 p. m.
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
        <link rel="stylesheet" href="estilos/estiloFrmciudad.css" />
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Registrar Administrador</h1>
        
        <form action="ControladorAdministrador" method="get">
            <input type="hidden" name="accion" value="agregar">
            Nombre: <input type="text" name="txtNombre"><br>
            Apellido: <input type="text" name="txtApellido"><br>
            Correo: <input type="text" name="txtCorreo"><br>
            Contraseña: <input type="password" name="clave"><br>
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
        
        <a href="homeAdmin.jsp">home</a>
        
    </body>
</html>