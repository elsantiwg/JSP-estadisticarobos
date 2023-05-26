
package modelo;

import java.util.List;


public class Informante extends Usuario{
    
    private String telefono;
    
    public Informante() {
    }



    public Informante(String telefono, int id, String nombre, String apellido, String correo, String contraseña) {
        super(id, nombre, apellido, correo, contraseña);
        this.telefono = telefono;
    }
     
    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}