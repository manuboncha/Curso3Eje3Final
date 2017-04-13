package com.manuboncha.appmascotas;

/**
 * Created by Manuel Bonilla on 26/03/2017.
 *
 * Clase coleccion de datos
 */

public class Mascotas {

    private int foto ;
    private String nombre ;
    private int calificacion;

    public  Mascotas (int foto, String nombre, int calificacion){
        this.foto = foto;
        this.nombre = nombre;
        this.calificacion = calificacion;

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
