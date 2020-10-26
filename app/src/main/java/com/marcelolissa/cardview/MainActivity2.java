package com.marcelolissa.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<Contactos> contactos;

    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle("  Petagram");
        getSupportActionBar().setIcon(R.drawable.home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        InicializarListaDeContactos();
        InicializarAdaptador();

    }

    public void InicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }

    public void InicializarListaDeContactos(){
        contactos = new ArrayList<Contactos>();

        contactos.add(new Contactos("Roco", R.drawable.roco, 5));
        contactos.add(new Contactos("Benito", R.drawable.benitol, 4));
        contactos.add(new Contactos("Lola", R.drawable.lola, 4));
        contactos.add(new Contactos("Terri", R.drawable.terri, 3));
        contactos.add(new Contactos("Bastis", R.drawable.bastis, 3));

    }
}