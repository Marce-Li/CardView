package com.marcelolissa.cardview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marcelolissa.cardview.R;
import com.marcelolissa.cardview.adapter.PerfilCircularAdaptador;
import com.marcelolissa.cardview.pojo.Contactos;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    private ArrayList<Contactos> contactos;
    private RecyclerView listaContactos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vPerview = inflater.inflate(R.layout.fragment_perfil, container, false);    //equivale inflar la vista (asignar a esta clase el layout)

        listaContactos = (RecyclerView) vPerview.findViewById(R.id.rvContactosCircular);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //listaContactos.setLayoutManager(llm);
        listaContactos.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        InicializarListaDeContactos();
        InicializarAdaptador();

        return vPerview;
    }

    public void InicializarAdaptador(){
        PerfilCircularAdaptador adaptador = new PerfilCircularAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }

    public void InicializarListaDeContactos(){
/*        contactos = new ArrayList<Contactos>();

        contactos.add(new Contactos("Lola", R.drawable.lola, 2));
        contactos.add(new Contactos("Roco", R.drawable.roco, 5));
        contactos.add(new Contactos("Benito", R.drawable.benitol, 3));
        contactos.add(new Contactos("Roco", R.drawable.roco, 4));
        contactos.add(new Contactos("Benito", R.drawable.benitol, 2));
        contactos.add(new Contactos("Lola", R.drawable.lola, 5));
        contactos.add(new Contactos("Terri", R.drawable.terri, 7));
        contactos.add(new Contactos("Bastis", R.drawable.bastis, 10));
        contactos.add(new Contactos("Noel", R.drawable.roco, 3));
        contactos.add(new Contactos("Fini", R.drawable.terri, 4));
        contactos.add(new Contactos("Gerry", R.drawable.bastis, 2));
*/
    }
}
