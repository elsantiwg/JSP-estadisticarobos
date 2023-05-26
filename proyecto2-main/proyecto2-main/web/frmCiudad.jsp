<%-- 
    Document   : frmRobo
    Created on : 1 may. 2023, 21:21:31
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>

<head>
    <title>Registrar ciudad</title>
    <link rel="stylesheet" href="estilos/estiloFrmciudad.css" />
    <script src="funciones.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>

    <header>
        <h1>Registrar ciudad</h1>
    </header>

    <form action="ControladorRobo" method="get">
        <p>Ciudad/Municipio</p><br>
        <input type="hidden" name="accion" value="agregar">
        <input type="text" name="txtCiudad" placeholder="Ciudad" ><br>
        <input type="text" name="txtBarrio" placeholder="Barrio"> <br>
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