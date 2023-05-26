
package modelo;

/**
 *
 * @author sebas
 */
public interface DAOInformante { 

    public boolean registrar (Informante informante);
    public void modificar (int id);
    public void eliminar (int id);
    public void buscar (int id);
    
    
}