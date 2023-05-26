
package modelo;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author sebas
 */
public class Datos_Robo implements IdatosRobo{
    
    private Connection miConexion;
    private PreparedStatement ps;
    private ResultSet rs;
    private String mensaje;
    private Robo r;

    public Datos_Robo() {
        miConexion=Conexion.getConexion();
    }
    
    private void cargarRoboID(int id){
        String sql="select * from ciudad where id="+id;
        r = new Robo();
        try {
            ps=miConexion.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                r.setIdRobo(rs.getInt(1));
                r.setCiudad(rs.getString(2));
                r.setBarrio(rs.getString(3));
                r.setnRobos(rs.getInt(4));

            }
            
        } catch (Exception e) {
        }
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public boolean agregarCiudad(Robo robo){
        boolean agregado=false;
        String consulta="insert into ciudad values (null,?,?,?)";
        try {
            ps= miConexion.prepareStatement(consulta);
            
            ps.setString(1, robo.getCiudad());
            ps.setString(2, robo.getBarrio());
            ps.setInt(3, robo.getnRobos());
            
            if(ps.executeUpdate()>0){
                agregado=true;
                mensaje="Ciudad agregada correctamente";
            }
        } catch (Exception e) {
            mensaje= e.getMessage();
        }
        return agregado;
    }
    
    public void eliminarCiudad(int id){
        String sql="DELETE FROM `ciudad` WHERE `id`="+id;
        
        try {
            ps = miConexion.prepareStatement(sql);
            ps.executeUpdate();
            mensaje="Ciudad eliminada correctamente";
        } catch (Exception e) {
            mensaje="problemas al eliminar";
        }
    }
    
    public void aumentarRobo(int id){
        
        cargarRoboID(id);
        int nRobo= r.getnRobos()+1;
        String sql = "UPDATE `ciudad` SET `nrobos`='"+nRobo+"' WHERE `id`="+id;
        
        try {
            ps = miConexion.prepareStatement(sql);
            ps.executeUpdate();
            mensaje="Robo agregado Correctamente";
        } catch (Exception e) {
        }
    }
    
    public void decrementarRobo(int id){
        cargarRoboID(id);
        //boolean rr=false;
        int nRobo= r.getnRobos()-1;
        if(nRobo<0){
            nRobo=0;
            mensaje="no hay robos en esta area. No se puede decrementar";
        }else{
            mensaje="Robo decrementado correctamente";
        }
        String sql = "UPDATE `ciudad` SET `nrobos`='"+nRobo+"' WHERE `id`="+id;
        
        try {
            ps = miConexion.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
            mensaje="Problemas al decrementar robo";
        }
    }
    
    public String[] arrayCiudades(){
     
        String sql="SELECT ciudad,sum(nrobos) as nrobos FROM `ciudad` WHERE 1 group by ciudad order by ciudad DESC;";
        ArrayList<String> dB = new ArrayList<>();
        
        try {
            ps=miConexion.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {
                
                dB.add(rs.getString(1));
                
            }
            
            String[] array= dB.toArray(new String[0]);
            return array;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public Integer[] arrayRobos(){
     
        String sql="SELECT ciudad,sum(nrobos) as nrobos FROM `ciudad` WHERE 1 group by ciudad order by ciudad DESC;";
        ArrayList<Integer> dB = new ArrayList<>();
        
        try {
            ps=miConexion.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {
                
                dB.add(rs.getInt(2));
                
            }
            
            Integer[] array= dB.toArray(new Integer[0]);
            return array;
        } catch (Exception e) {
            return null;
        }
    }
    
    public String[] arrayBarrios(String ciudad){
     
        String sql="SELECT * FROM `ciudad` WHERE `ciudad`=\""+ciudad+"\";";
        ArrayList<String> dB = new ArrayList<>();
        
        try {
            ps=miConexion.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {
                
                dB.add(rs.getString(3));
                
            }
            
            String[] array= dB.toArray(new String[0]);
            mensaje="array enviado";
            return array;
        } catch (Exception e) {
            mensaje="problemas con array";
            return null;
        }
        
    }
    
    public Integer[] arrayRobos(String ciudad){
     
        String sql="SELECT * FROM `ciudad` WHERE `ciudad`=\""+ciudad+"\";";
        ArrayList<Integer> dB = new ArrayList<>();
        
        try {
            ps=miConexion.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {
                
                dB.add(rs.getInt(4));
                
            }
            
            Integer[] array= dB.toArray(new Integer[0]);
            mensaje="array enviado";
            return array;
        } catch (Exception e) {
            mensaje="problemas con array";
            return null;
        }
    }
}
