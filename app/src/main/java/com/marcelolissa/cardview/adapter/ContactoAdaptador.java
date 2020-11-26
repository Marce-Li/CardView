package com.marcelolissa.cardview.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marcelolissa.cardview.db.ConstructorContactos;
import com.marcelolissa.cardview.pojo.Contactos;
import com.marcelolissa.cardview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contactos> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contactos> contactos){this.contactos = contactos;}

    public ContactoAdaptador(ArrayList<Contactos> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    @NonNull

    //Infla el layout y pasara al viewHolder para que tenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la vista con cada view
    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
        final Contactos contaco = contactos.get(position);
        Picasso.with(activity)
                .load(contaco.getUrlFoto())
                .placeholder(R.drawable.benitol)    //imagen en caso de que no se encuentre una imagen
                .into(contactoViewHolder.imgCardPerfil);    //donde se debe insertar la imagen de la url
        contactoViewHolder.tvLike.setText((contaco.getLike()).toString());
    }

    //Cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        //Variables para manejar cada elemento del cardView
        private ImageView imgCardPerfil;
        private TextView tvLike;


        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCardPerfil = (ImageView) itemView.findViewById(R.id.circularImageViewgrid);
            tvLike = (TextView) itemView.findViewById(R.id.tvFechaGrid);
        }
    }


}
