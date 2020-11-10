package com.marcelolissa.cardview.db;

public class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "MASCOTA";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTA           = "mascota";
    public static final String TABLE_MASCOTA_ID        = "id";
    public static final String TABLE_MASCOTA_NOMBRE    = "nombre";
    public static final String TABLE_MASCOTA_FOTO      = "foto";

    public static final String TABLE_LIKES_MASCOTA                  = "mascota_likes";
    public static final String TABLE_LIKES_MASCOTA_ID               = "id";
    public static final String TABLE_LIKES_MASCOTA_ID_CONTACTO      = "id_mascota";
    public static final String TABLE_LIKES_MASCOTA_NUMERO_LIKES     = "numero_likes";
    public static final String TABLE_LIKES_MASCOTA_NUMERO_DISLIKES  = "numero_dislikes";

}
