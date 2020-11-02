package com.marcelolissa.cardview.pojo;

public class Contactos {

    private String nombre;
    private int foto;
    private int like;

    public Contactos(String nombre, int foto, int like) {
        this.nombre = nombre;
        this.foto = foto;
        this.like = like;
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

    public void sumarlike() { this.like = like + 1;}

    public void restarlike() {
        if(this.like > 0)
            this.like = like - 1;
    }
}