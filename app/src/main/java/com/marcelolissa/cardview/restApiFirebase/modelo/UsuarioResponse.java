package com.marcelolissa.cardview.restApiFirebase.modelo;

public class UsuarioResponse {
    private String id;
    private String id_dispositivo;
    private String id_usuario;
    private String id_foto_instagram;

    public UsuarioResponse() {
    }

    public UsuarioResponse(String id, String id_dispositivo, String id_usuario, String id_foto_instagram) {
        this.id = id;
        this.id_dispositivo = id_dispositivo;
        this.id_usuario = id_usuario;
        this.id_foto_instagram = id_foto_instagram;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_foto_instagram() {
        return id_foto_instagram;
    }

    public void setId_foto_instagram(String id_foto_instagram) {
        this.id_foto_instagram = id_foto_instagram;
    }
}
