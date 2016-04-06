package mx.itesm.edu.dondeir;

/**
 * Created by harryHaller on 29/02/16.
 */
public class Sitio {

    private String nombre,categoria;
    private double latitude, longitude;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public void setCategoria(String categoria){this.categoria = categoria;}
    public String getCategoria(){return this.categoria;}
}
