package com.marcelolissa.cardview.menufavorito;

import android.content.Context;

import com.marcelolissa.cardview.db.ConstructorContactos;
import com.marcelolissa.cardview.db.ConstructorContactosFavoritos;
import com.marcelolissa.cardview.fragment.IRecyclerViewFragmentView;
import com.marcelolissa.cardview.pojo.Contactos;
import com.marcelolissa.cardview.presentador.IRecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFavoritoPresenter implements IRecyclerViewFavoritoPresenter {

    private IRecyclerViewFavoritoPresenter iRecyclerViewFavoritoPresenter;
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactosFavoritos constructorContactos;
    private ArrayList<Contactos> contactos;

    public RecyclerViewFavoritoPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactos();
    }

    @Override
    public void obtenerContactos() {
        constructorContactos = new ConstructorContactosFavoritos(context);
        contactos = null;
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
