package mx.itesm.edu.dondeir;

import java.io.Serializable;

/**
 * Created by harryHaller on 29/02/16.
 */
public class Item implements Serializable{
    private String titulo, archivo;
    private String color;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return  titulo ;
    }
}
