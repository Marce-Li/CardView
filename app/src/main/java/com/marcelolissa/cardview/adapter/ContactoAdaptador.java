package com.marcelolissa.cardview.adapter;

import android.app.Activity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.iid.FirebaseInstanceId;

import com.marcelolissa.cardview.pojo.Contactos;
import com.marcelolissa.cardview.R;
import com.marcelolissa.cardview.restApiFirebase.Endpoints;
import com.marcelolissa.cardview.restApiFirebase.adapter.RestApiAdapter;
import com.marcelolissa.cardview.restApiFirebase.modelo.UsuarioResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        contactoViewHolder.ivhueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like, espera la notificación", Toast.LENGTH_SHORT).show();
                enviarIdtokenIdUsuario(contaco.getIdFoto());
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
        private TextView tvLike;
        private ImageView ivhueso;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCardPerfil = (ImageView) itemView.findViewById(R.id.circularImageViewgrid);
            tvLike = (TextView) itemView.findViewById(R.id.tvFechaGrid);
            ivhueso = (ImageView) itemView.findViewById(R.id.ivhueso);
        }
    }

    private void enviarIdtokenIdUsuario(String id_foto_instagram){
        String token = FirebaseInstanceId.getInstance().getToken();
        String USER_ID = "17841444055836399";
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Endpoints endpoints = restApiAdapter.establecerConexionRestApi();
        Call<UsuarioResponse> usuarioResponseCall = endpoints.registrarUsuario(token, USER_ID, id_foto_instagram);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("ID_FIREBASE", usuarioResponse.getId());
                Log.d("ID_DISPOSITIVO", usuarioResponse.getId_dispositivo());
                Log.d("ID_USUARIO", usuarioResponse.getId_usuario());
                notificaciónFirebase(usuarioResponse.getId(),"");
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }

    private void notificaciónFirebase (String Id, String Id_dispositivo) {
        UsuarioResponse usuarioResponse = new UsuarioResponse(Id, Id_dispositivo, "", "");
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Endpoints endpoints = restApiAdapter.establecerConexionRestApi();
        Call<UsuarioResponse> usuarioResponseCall = endpoints.notificacion(usuarioResponse.getId());
        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse1 = response.body();
                Log.d("ID_FIREBASE_NOTIF", usuarioResponse1.getId());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }

}
