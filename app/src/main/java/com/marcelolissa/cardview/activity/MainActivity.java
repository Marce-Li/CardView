package com.marcelolissa.cardview.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.marcelolissa.cardview.R;
import com.marcelolissa.cardview.adapter.PageAdapter;
import com.marcelolissa.cardview.fragment.PerfilFragment;
import com.marcelolissa.cardview.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

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
            default:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }


}