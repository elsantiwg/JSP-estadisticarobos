
package modelo;

/**
 *
 * @author sebas
 */
public interface DAOAdministrador { 

    public boolean registrar (Administrador administrador);
    public void modificar (int id);
    public void eliminar (int id);
    public void buscar (int id);
    
    
}