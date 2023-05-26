
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOInformanteImplementacion implements DAOInformante{

    
    private Connection miConexion;
    private PreparedStatement ps;
    private ResultSet rs;
    private String mensaje;
    private Informante i;

    public DAOInformanteImplementacion() {
        miConexion=Conexion.getConexion();
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    
    
    @Override
    public boolean registrar(Informante informante) {

        boolean agregado=false;
        String consulta="insert into informante values (null,?,?,?,?,?)";
        try {
            ps= miConexion.prepareStatement(consulta);
            ps.setString(1, informante.getNombre());
            ps.setString(2, informante.getApellido());
            ps.setString(3, informante.getCorreo());
            ps.setString(4, informante.getContraseña());
            ps.setString(5, informante.getTelefono());
            
            if(ps.executeUpdate()>0){
                agregado=true;
                mensaje="informante agregada correctamente";
            }
        } catch (Exception e) {
            mensaje= e.getMessage();
        }
        return agregado;
    }

    
    @Override
    public void modificar(int id) {
        String sql="UPDATE informante WHERE `id`="+id;
        i = new Informante();
        try {
            ps = miConexion.prepareStatement(sql);
            
            i.setNombre(rs.getString(2));
            i.setApellido(rs.getString(3));
            i.setCorreo(rs.getString(4));
            i.setContraseña(rs.getString(5));
            i.setTelefono(rs.getString(6));
            
            ps.executeUpdate();
            mensaje="Informante actualizado correctamente";
        } catch (Exception e) {
            mensaje="problemas al actualizar";
        }
    }
    

    @Override
    public void eliminar(int id) {
        String sql="DELETE FROM `informante` WHERE `id`="+id;
        
        try {
            ps = miConexion.prepareStatement(sql);
            ps.executeUpdate();
            mensaje="Informante eliminado correctamente";
        } catch (Exception e) {
            mensaje="problemas al eliminar";
        }
    }

    @Override
    public void buscar(int id) {

        String sql="select * from informante where id="+id;
        i = new Informante();
        try {
            ps=miConexion.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){     
                i.setId(rs.getInt(1));
                i.setNombre(rs.getString(2));
                i.setApellido(rs.getString(3));
                i.setCorreo(rs.getString(4));
                i.setContraseña(rs.getString(5));
                i.setTelefono(rs.getString(6));
            }
        } catch (Exception e) {
        }

    }
    
    public boolean verificar(String correo, String contraseña) {
        String sql = "SELECT * FROM informante WHERE correo = \""+correo+"\" AND contraseña = \""+contraseña+"\"";
        i = new Informante();
        boolean encontrado = false;
        try {
            ps = miConexion.prepareStatement(sql);
           // ps.setString(1, correo);
           // ps.setString(2, contraseña);
            rs = ps.executeQuery();
            while (rs.next()) {
                i.setId(rs.getInt(1));
                i.setNombre(rs.getString(2));
                i.setApellido(rs.getString(3));
                i.setCorreo(rs.getString(4));
                i.setContraseña(rs.getString(5));
                i.setTelefono(rs.getString(6));
                encontrado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encontrado;
    }
    
}