
package controlador;

import modelo.*;

/**
 *
 * @author sebas
 */
public class ControladorD {
    
    private static Datos_Robo db = new Datos_Robo();
    private static String[] barrios;
    private static Integer[] nRobos;
    private static String mensaje;
    
    
    
    public static String getmensje(){
        return mensaje;
    }
    
    public static void barrios(String ciudad){
        
        ControladorD.barrios= db.arrayBarrios(ciudad);
        mensaje= db.getMensaje();
        
    }
    
    public static void robosC(String ciudad){
        
        ControladorD.nRobos=db.arrayRobos(ciudad);
        
    }

    public static String[] getBarrios() {
        return barrios;
    }

    public static Integer[] getnRobos() {
        return nRobos;
    }

    
}
