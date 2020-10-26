package com.marcelolissa.cardview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contactos> contactos;

    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle("  Petagram");
        getSupportActionBar().setIcon(R.drawable.home);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        InicializarListaDeContactos();
        InicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        switch (item.getItemId())
        {
            case R.id.favoritos:
                startActivity(intent);
                break;
            default:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }

    public void InicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }

    public void InicializarListaDeContactos(){
        contactos = new ArrayList<Contactos>();

        contactos.add(new Contactos("Roco", R.drawable.roco, 0));
        contactos.add(new Contactos("Benito", R.drawable.benitol, 0));
        contactos.add(new Contactos("Lola", R.drawable.lola, 0));
        contactos.add(new Contactos("Terri", R.drawable.terri, 0));
        contactos.add(new Contactos("Bastis", R.drawable.bastis, 0));
        contactos.add(new Contactos("Noel", R.drawable.roco, 0));
        contactos.add(new Contactos("Fini", R.drawable.terri, 0));
        contactos.add(new Contactos("Gerry", R.drawable.bastis, 0));
    }

}