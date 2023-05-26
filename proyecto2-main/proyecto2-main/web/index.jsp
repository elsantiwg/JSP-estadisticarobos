<%-- 
    Document   : index
    Created on : 6 may. 2023, 11:53:44
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controlador.*" %>
<%@page import="modelo.*" %>
<%@page import="com.google.gson.Gson" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Robos en las ciudades</title>
        <link rel="stylesheet" href="estilos/estiloIndex.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    </head>
    <body>

        <div id="barra">
            
            <ul>
                <h1>Mira los robos en tu ciudad</h1>
                <p>Para reportar un robo en tu ciudad debes registrarte como usuario:</p><br>
                <li><a href="robosPorCiudad.jsp">Robos por ciudad</a></li>
                <li><a href="frmUsuario.jsp">Registrar usuario</a></li>
                <li><a href="loginUsuario.jsp">Iniciar sesion</a></li>
                <li><a href="loginAdmin.jsp">Iniciar sesion como Administrador</a></li>
            </ul>
        </div>
        <% 
                Datos_Robo dRobos = new Datos_Robo();
                
                String[] ciudades = dRobos.arrayCiudades();
                Integer[] robos = dRobos.arrayRobos();
                
                Gson gson = new Gson();
                String ciudadesJS = gson.toJson(ciudades);
                String robosJS = gson.toJson(robos);
                
            %>
 
        <canvas id="MiGrafica" width="400 rem" height="auto"></canvas>
        
        
        <script>
            
            
            
            
            var ciudades= <%=ciudadesJS %>;
            var robos= <%=robosJS %>;

            let MiCanvas=document.getElementById("MiGrafica").getContext("2d");

            var chart = new Chart(MiCanvas,{
                type:"bar",
                data:{
                    labels:ciudades,
                    datasets:[
                    {
                        label: "Robos en las ciudades",
                        backgroundColor: "rgb(0,0,0)",
                        borderColor: "rgb(o,255,0)",
                        data:robos
                    }
                    ]
                }
            });

        </script>


    </body>
</html>
