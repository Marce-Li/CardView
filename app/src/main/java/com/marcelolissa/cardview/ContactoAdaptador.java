package com.marcelolissa.cardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contactos> contactos;

    public ContactoAdaptador(ArrayList<Contactos> contactos){
        this.contactos = contactos;
    }

    @NonNull

    //Infla el layout y pasara al viewHolder para que tenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la vista con cada view
    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
        final Contactos contaco = contactos.get(position);
        contactoViewHolder.imgCardPerfil.setImageResource(contaco.getFoto());
        contactoViewHolder.tvCardNombre.setText(contaco.getNombre());
        contactoViewHolder.tvLikes.setText(Integer.toString(contaco.getLike()));

        contactoViewHolder.ivlike.setOnClickListener(new View.OnClickListener() {   //Cuando se presiona sobre el hueso blanco
            @Override                                                               //aumenta la cantidad de likes
            public void onClick(View v) {
                contaco.sumarlike();
                contactoViewHolder.tvLikes.setText(Integer.toString(contaco.getLike()));
            }
        });
        contactoViewHolder.ivdislike.setOnClickListener(new View.OnClickListener() {    //Cuando se presiona sobre el hueso amarillo
            @Override                                                                   //disminuye la cantidad de likes
            public void onClick(View v) {
                contaco.restarlike();
                contactoViewHolder.tvLikes.setText(Integer.toString(contaco.getLike()));
            }
        });
    }

    //Cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        //Variables para manejar cada elemento del cardView
        private ImageView imgCardPerfil;
        private TextView tvCardNombre;
        private TextView tvLikes;
        private ImageView ivlike, ivdislike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCardPerfil = (ImageView) itemView.findViewById(R.id.imgCardFoto);
            tvCardNombre = (TextView) itemView.findViewById(R.id.tvCardNombre);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
            ivlike = (ImageView) itemView.findViewById(R.id.ivhuesoLike);
            ivdislike = (ImageView) itemView.findViewById(R.id.ivhuesoDisLike);
        }
    }


}
