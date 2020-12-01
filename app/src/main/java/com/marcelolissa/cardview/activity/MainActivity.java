package com.marcelolissa.cardview.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.iid.FirebaseInstanceId;
import com.marcelolissa.cardview.R;
import com.marcelolissa.cardview.adapter.PageAdapter;
import com.marcelolissa.cardview.fragment.PerfilFragment;
import com.marcelolissa.cardview.fragment.RecyclerViewFragment;
import com.marcelolissa.cardview.restApiFirebase.Endpoints;
import com.marcelolissa.cardview.restApiFirebase.adapter.RestApiAdapter;
import com.marcelolissa.cardview.restApiFirebase.modelo.UsuarioResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String TAG = "FIREBASE_TOKEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViePager();
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFragmentes(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViePager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragmentes()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.perro);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.favoritos:
                Intent intentFav = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intentFav);
                break;
            case R.id.menContacto:
                Intent intentCont = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(intentCont);
                break;
            case R.id.menAcercaDe:
                Intent intetntBio = new Intent(MainActivity.this, BioDesarrollador.class);
                startActivity(intetntBio);
                break;
            case R.id.configCuenta:
                Intent intetntConfig = new Intent(MainActivity.this, ConfigurarCuenta.class);
                startActivity(intetntConfig);
                break;
            case R.id.menNotificaciones:
                String token = FirebaseInstanceId.getInstance().getToken();
                Log.d(TAG, token);
                //enviarIdtokenIdUsuario(token);
                break;
            default:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

/*    private void enviarIdtokenIdUsuario(String token){
        String USER_ID = "17841444055836399";
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Endpoints endpoints = restApiAdapter.establecerConexionRestApi();
        Call<UsuarioResponse> usuarioResponseCall = endpoints.registrarUsuario(token, USER_ID,"1234");

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                Log.d("ID_FIREBASE", usuarioResponse.getId());
                Log.d("ID_DISPOSITIVO", usuarioResponse.getId_dispositivo());
                Log.d("ID_USUARIO", usuarioResponse.getId_usuario());

            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });



    }*/

/*    private void notificaciónFirebase (String Id, String Id_dispositivo){
        UsuarioResponse usuarioResponse = new UsuarioResponse(Id_dispositivo,Id,"123","123");
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Endpoints endpoints = restApiAdapter.establecerConexionRestApi();
        Call<UsuarioResponse> usuarioResponseCall = endpoints.notificacion(usuarioResponse.getId());
        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse1 = response.body();
                Log.d("ID_FIREBASE", usuarioResponse1.getId());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });

    }*/
}