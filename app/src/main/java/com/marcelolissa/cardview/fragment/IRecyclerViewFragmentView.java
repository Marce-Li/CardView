package com.marcelolissa.cardview.fragment;

import com.marcelolissa.cardview.adapter.ContactoAdaptador;
import com.marcelolissa.cardview.pojo.Contactos;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public ContactoAdaptador crearAdaptador(ArrayList<Contactos> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);

}
