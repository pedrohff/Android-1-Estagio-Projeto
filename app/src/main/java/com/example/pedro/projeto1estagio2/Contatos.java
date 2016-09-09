package com.example.pedro.projeto1estagio2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.pedro.projeto1estagio2.adapters.ContatoAdapter;
import com.example.pedro.projeto1estagio2.core.controllers.ControllerMainActivity;
import com.example.pedro.projeto1estagio2.models.Contato;


import java.util.ArrayList;
import java.util.Random;

public class Contatos extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView tvNavUser;
    private RecyclerView rv;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Meu codigo
        rv = (RecyclerView)findViewById(R.id.rvContatos);
        rv.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);

        String[] nomes = new String[]{"Miguel","Sophia","Davi","Alice","Arthur","Julia","Pedro","Isabella","Gabriel","Manuela","Bernardo","Laura","Lucas","Luiza","Matheus","Valentina","Rafael","Giovanna","Heitor","Maria Eduarda","Enzo","Helena","Guilherme","Beatriz","Nicolas","Maria Luiza","Lorenzo","Lara","Gustavo","Mariana","Felipe","Nicole"};

        ArrayList<Contato> contatos= new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Contato contato = new Contato();
            contato.setNome(nomes[i]);
            contato.setTelefone(99999999 - (17393 * (i* i)));
            contatos.add(contato);
        }
        mAdapter = new ContatoAdapter(this, contatos);
        rv.setAdapter(mAdapter);
    }

    /*@Override
    protected void onResume() {
        super.onResume();
        tvNavUser.setText(ControllerMainActivity.getInstance().getLogin());
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        tvNavUser = (TextView)findViewById(R.id.tvNav_user);
        tvNavUser.setText(ControllerMainActivity.getInstance().getLogin());
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contatos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_configuracoes) {
            Intent configurationIntent = new Intent(this, Configuracoes.class);
            startActivity(configurationIntent);
        } else if (id == R.id.nav_accessWebsite) {
            Intent accessWebsiteIntent = new Intent(this, AccessWebsite.class);
            startActivity(accessWebsiteIntent);
        }/* else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void editProfile(View v){
        Intent i = new Intent(this, EditarPerfil.class);
        startActivity(i);
    }
}
