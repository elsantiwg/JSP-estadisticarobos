<%-- 
    Document   : frmRobo
    Created on : 2 may. 2023, 16:31:17
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controlador.*" %>
<%@page import="modelo.*" %>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar ciudad</title>
        <link rel="stylesheet" href="estilos/estiloEliminarciudad.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1>Eliminar ciudad</h1>
        
        <form action="ControladorRobo" method="post">
            <input type="hidden" id="id" name="accion" value="EliminarC">
            <select name="Ciudad" id="" size="5">
            <% 
                Statement s= Conexion.getConexion().createStatement();
                ResultSet rs= s.executeQuery("SELECT * FROM `ciudad` WHERE 1 order by ciudad,barrio");
            
                while(rs.next()){
                    out.print("<option value="+rs.getInt(1)+">"+rs.getString(2)+"  --------    "+rs.getString(3)+"</option>");
                }
            
            %>
            
            </select><br>
            <input type="submit" value="Eliminar">
        </form>
            
        <a href="homeAdmin.jsp">home</a>
        <% 
            String mensaje= request.getParameter("mensaje");
            if(mensaje!= null){
                out.print(mensaje);
            }
        %>
        
        
    </body>
</html>
