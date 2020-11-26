package com.marcelolissa.cardview.pojo;

public class Contactos {

    private String ID;
    private String nombre;
    private String urlFoto;
    private String like;

    public Contactos(String nombre, String urlFoto) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
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

    public String getLike() { return like; }

    public void setLike(String like) { this.like = like; }
}