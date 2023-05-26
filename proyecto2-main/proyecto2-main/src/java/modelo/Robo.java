
package modelo;

/**
 *
 * @author sebas
 */
public class Robo {
    
    private int idRobo;
    private String ciudad;
    private String barrio;
    private int nRobos;

    public Robo(String ciudad, String barrio, int nRobos) {
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.nRobos = nRobos;
    }

    public Robo() {
    }

    public int getnRobos() {
        return nRobos;
    }

    public void setnRobos(int nRobos) {
        this.nRobos = nRobos;
    }
    
    public int getIdRobo() {
        return idRobo;
    }

    public void setIdRobo(int idRobo) {
        this.idRobo = idRobo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    
    
    

}
