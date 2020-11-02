package com.marcelolissa.cardview.adapter;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.marcelolissa.cardview.pojo.Contactos;
        import com.marcelolissa.cardview.R;
        import com.mikhaellopez.circularimageview.CircularImageView;

        import java.util.ArrayList;

public class PerfilCircularAdaptador extends RecyclerView.Adapter<PerfilCircularAdaptador.perfilContactoViewHolder> {

    ArrayList<Contactos> contactos2;

    public PerfilCircularAdaptador(ArrayList<Contactos> contactos){
        this.contactos2 = contactos;
    }

    @NonNull

    //Infla el layout y pasara al viewHolder para que tenga los views
    @Override
    public perfilContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        return new perfilContactoViewHolder(v2);
    }

    //Asocia cada elemento de la vista con cada view
    @Override
    public void onBindViewHolder(@NonNull final perfilContactoViewHolder perfilContactoViewHolder, int position) {
        final Contactos contaco = contactos2.get(position);
        perfilContactoViewHolder.imgCardPerfil.setImageResource(contaco.getFoto());
        perfilContactoViewHolder.tvLikes.setText(Integer.toString(contaco.getLike()));

        perfilContactoViewHolder.ivdislike.setOnClickListener(new View.OnClickListener() {    //Cuando se presiona sobre el hueso amarillo
            @Override                                                                   //disminuye la cantidad de likes
            public void onClick(View v2) {
                contaco.restarlike();
                perfilContactoViewHolder.tvLikes.setText(Integer.toString(contaco.getLike()));
            }
        });

    }

    //Cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return contactos2.size();
    }

    public static class perfilContactoViewHolder extends RecyclerView.ViewHolder{
        //Variables para manejar cada elemento del cardView
        private ImageView imgCardPerfil, ivdislike;
        private TextView tvLikes;


        public perfilContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCardPerfil = (ImageView) itemView.findViewById(R.id.circularImageView);
            ivdislike = (ImageView) itemView.findViewById(R.id.ivhuesoDisLikeCircular);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikesCircular);
        }
    }


}
