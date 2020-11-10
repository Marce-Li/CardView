package com.marcelolissa.cardview.pojo;

public class Contactos {

    private int ID;
    private String nombre;
    private int foto;
    private int like = 0;
    private int dis_like = 0;

    public Contactos(String nombre, int foto, int like) {
        this.nombre = nombre;
        this.foto = foto;
        this.like = like;
    }

    public Contactos() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLike() { return this.like; }

    public void setLike(int like) { this.like = like; }

    public int getID() { return ID;}

    public void setID(int ID) { this.ID = ID;}

    public int getDis_like() { return dis_like;}

    public void setDis_like(int dis_like) { this.dis_like = dis_like;}

    public void sumarlike() { this.like = like + 1;}

    public void restarlike() { this.dis_like = dis_like + 1;}

}