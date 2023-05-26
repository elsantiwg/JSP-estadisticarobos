<%-- 
    Document   : frmRobo
    Created on : 2 may. 2023, 16:31:17
    Author     : sebas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controlador.*" %>
<%@page import="modelo.*" %>
<%@page import="java.sql.*" %>
<%@page import="com.google.gson.Gson" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grafica de cada ciudad</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <link rel="stylesheet" href="estilos/estiloDecrementarrobo.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1>Robos por ciudad</h1>
        
        <form action="ControladorRobo" method="post">
            <input type="hidden" id="id" name="accion" value="PorCiudad">
            <select name="Ciudad" id="" size="5">
            <% 
                Statement s= Conexion.getConexion().createStatement();
                ResultSet rs= s.executeQuery("SELECT ciudad,sum(nrobos) as nrobos FROM `ciudad` WHERE 1 group by ciudad order by ciudad;");
            
                while(rs.next()){
                    out.print("<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>");
                }
            
            %>
            
            </select><br>
            <input type="submit" value="Ver">
        </form>
            
        <a href="index.jsp">home</a>
        <% 
            String mensaje= request.getParameter("mensaje");
            if(mensaje!= null){

                String[] barrios = ControladorD.getBarrios();
                Integer[] robos = ControladorD.getnRobos();
                
                Gson gson = new Gson();
                
                String b = gson.toJson(barrios);
                String r = gson.toJson(robos);
                
            
            
            
        %>
        
        <canvas id="MiGrafica" width="500 rem" height="auto"></canvas>
        
        <script>
            
            
            
            
            var ciudades= <%=b%>;
            var robos= <%=r%>;

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
        <%}%>
        
    </body>
</html>
