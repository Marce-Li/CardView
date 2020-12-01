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

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

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

        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViePager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragmentes()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.perro);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

}