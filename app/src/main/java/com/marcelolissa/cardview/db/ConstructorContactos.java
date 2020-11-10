package com.marcelolissa.cardview.db;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import com.marcelolissa.cardview.R;
import com.marcelolissa.cardview.pojo.Contactos;

import java.util.ArrayList;

public class ConstructorContactos {

    private static final int LIKE = 1;
    private static final int DISLIKE = 1;
    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contactos> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarCincoContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarCincoContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Roco");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.roco);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Benito");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.benitol);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Lola");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.lola);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Terri");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.terri);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Bastis");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.bastis);

        db.insertarContacto(contentValues);

    }

    public void darLikeCotnacto(Contactos contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_CONTACTO, contacto.getID());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public void darDisLikeCotnacto(Contactos contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_CONTACTO, contacto.getID());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_DISLIKES, DISLIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contactos contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }

    public int obtenerDisLikesContacto(Contactos contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerDisLikesContacto(contacto);
    }

}
