package com.marcelolissa.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

import com.marcelolissa.cardview.R;
import com.marcelolissa.cardview.adapter.ContactoAdaptador;
import com.marcelolissa.cardview.fragment.IRecyclerViewFragmentView;
import com.marcelolissa.cardview.menufavorito.RecyclerViewFavoritoPresenter;
import com.marcelolissa.cardview.pojo.Contactos;
import com.marcelolissa.cardview.presentador.IRecyclerViewFragmentPresenter;
import com.marcelolissa.cardview.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements IRecyclerViewFragmentView {

    ArrayList<Contactos> contactos;
    SQLiteOpenHelper conexion;

    private Context context;
    private RecyclerView listaContactos;
    private RecyclerViewFavoritoPresenter presenter;

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
        presenter = new RecyclerViewFavoritoPresenter(this, this);

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contactos> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        listaContactos.setAdapter(adaptador);
    }

}