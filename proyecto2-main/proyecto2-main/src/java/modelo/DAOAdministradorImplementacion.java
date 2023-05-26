
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOAdministradorImplementacion implements DAOAdministrador{

    
    private Connection miConexion;
    private PreparedStatement ps;
    private ResultSet rs;
    private String mensaje;
    private Administrador a;

    public DAOAdministradorImplementacion() {
        miConexion=Conexion.getConexion();
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    
    
    @Override
    public boolean registrar(Administrador administrador) {

        boolean agregado=false;
        String consulta="insert into administrador values (null,?,?,?,?)";
        try {
            ps= miConexion.prepareStatement(consulta);
            ps.setString(1, administrador.getNombre());
            ps.setString(2, administrador.getApellido());
            ps.setString(3, administrador.getCorreo());
            ps.setString(4, administrador.getContraseña());
            
            if(ps.executeUpdate()>0){
                agregado=true;
                mensaje="administrador agregado correctamente";
            }
        } catch (Exception e) {
            mensaje= e.getMessage();
        }
        return agregado;
    }

    
    @Override
    public void modificar(int id) {
        String sql="UPDATE administrador WHERE `id`="+id;
        a = new Administrador();
        try {
            ps = miConexion.prepareStatement(sql);
            
            a.setNombre(rs.getString(1));
            a.setApellido(rs.getString(2));
            a.setCorreo(rs.getString(3));
            a.setContraseña(rs.getString(4));
            
            ps.executeUpdate();
            mensaje="administrador actualizado correctamente";
        } catch (Exception e) {
            mensaje="problemas al actualizar";
        }
    }
    

    @Override
    public void eliminar(int id) {
        String sql="DELETE FROM `administrador` WHERE `id`="+id;
        
        try {
            ps = miConexion.prepareStatement(sql);
            ps.executeUpdate();
            mensaje="Administrador eliminado correctamente";
        } catch (Exception e) {
            mensaje="problemas al eliminar";
        }
    }

    @Override
    public void buscar(int id) {

        String sql="select * from administrador where id="+id;
        a = new Administrador();
        try {
            ps=miConexion.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){     
                a.setId(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setCorreo(rs.getString(4));
                a.setContraseña(rs.getString(5));
            }
        } catch (Exception e) {
        }

    }
    
    public boolean verificar(String correo, String contraseña) {
        String sql = "SELECT * FROM administrador WHERE correo = ? AND contraseña = ?";
        a = new Administrador();
        boolean encontrado = false;
        try {
            ps = miConexion.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            while (rs.next()) {
                a.setId(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setCorreo(rs.getString(4));
                a.setContraseña(rs.getString(5));
                encontrado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encontrado;
    }
    
}