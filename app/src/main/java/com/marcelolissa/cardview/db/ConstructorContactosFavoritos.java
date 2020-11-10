package com.marcelolissa.cardview.db;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import com.marcelolissa.cardview.R;
import com.marcelolissa.cardview.pojo.Contactos;

import java.util.ArrayList;


public class ConstructorContactosFavoritos {

    private Context context;
    ArrayList<Contactos> mascotas = new ArrayList<>();

    public ConstructorContactosFavoritos(Context context) {this.context = context;}

    public ArrayList<Contactos> obtenerDatos() {

        int valor;      //Para guardar el valor de los likes
        int valorAuxiliar = 1000;       //para iniciar un valor maximo
        int pos = 0;    //posicion del vector donde se encuentra el like
        ArrayList<Integer> listaLike = new ArrayList<>();   //para generar arreglo con los valores de likes de cada id
        ArrayList<Contactos> mascotasfavoritas = new ArrayList<>(); //para guardar las 5 mascotas con más likes

        int j;

        //Obtengo todos los objetos correspondientes a cada mascotas
        BaseDatos db = new BaseDatos(context);
        mascotas = db.obtenerTodosLosContactos();

        //Obtengo los likes de cada mascota
        for(int i = 0; i < mascotas.size(); i++){
            listaLike.add(obtenerLikesContacto(mascotas.get(i)));
        }

        //Busco los que más like tiene
        for(int i = 0; i < 5; i++){ //recorro 5 veces el vector
            valor = 0;
            j = 0;
            pos = 0;
            while (j < listaLike.size()){   //mientras no se termine de recorrer la lista
                if(valor < listaLike.get(j) && listaLike.get(j) < valorAuxiliar){   //si el valor actual es menor al que tiene la lista y el valor que tiene la lista es menor que el maximo ya encontrado
                    valor = listaLike.get(j);       //actualizo el valor para ir obteniendo siempre el mayor
                    pos = j;    //Guardo la posicion donde se encontraba el valor
                }
                j++;
            }
            valorAuxiliar = valor;  //actualizo el valor maximo encontrado, que va a ir siendo menor en cada vuelta de While para que no se repita siempre el mismo valor
            mascotasfavoritas.add(i, mascotas.get(pos));    //Guardo en el arreglo mascotasfavoritas el objeto que tiene el like mayor de cada vuelta
        }

        db.close();
        return mascotasfavoritas;
    }

    public int obtenerLikesContacto(Contactos contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
