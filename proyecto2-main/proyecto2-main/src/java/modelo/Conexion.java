package modelo;

import java.sql.*;

/**
 *
 * @author sebas
 */
public class Conexion {

    private static Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static String mensaje;

    public static Connection getConexion() {
        if (conexion != null) {
            return conexion;
        }
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, password);
            mensaje = "Conectado a la base de datos";
            return conexion;
        } catch (Exception e) {
            mensaje = e.getMessage();
            return null;
        }
    }

    public static void cerrar(){
        try {
            conexion.close();
            mensaje="Conexion cerrada";
        } catch (Exception e) {
            mensaje="Problemas al cerrar la conexion";
        }
    }
    
    public static String getMensaje(){
        return mensaje;
    }

}
