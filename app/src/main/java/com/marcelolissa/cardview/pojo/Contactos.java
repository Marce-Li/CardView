package com.marcelolissa.cardview.pojo;

public class Contactos {

    private String ID;
    private String nombre;
    private String urlFoto;
    private String fecha;

    public Contactos(String nombre, String urlFoto, String fecha) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.fecha = fecha;
    }

    public Contactos() {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}