package com.krivic.mascotitas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import static com.krivic.mascotitas.R.id.rvMascota;

public class MainActivity extends AppCompatActivity {

    ArrayList<com.krivic.mascotitas.Mascotas> datos;
    ArrayList<com.krivic.mascotitas.Mascotas> favoritos;
    private RecyclerView vMascota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miaction_bar= (Toolbar)findViewById(R.id.miaction_bar);
        setSupportActionBar(miaction_bar);

        //ingresamos al activity main
        vMascota=(RecyclerView)findViewById(rvMascota);

        //lista de datos
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        vMascota.setLayoutManager(llm);

        InicializaListaContacto();
        InicializarlistaAdaptador();
    }

    public Adaptador_Mascotas adaptador;
    private void InicializarlistaAdaptador(){
        adaptador=new Adaptador_Mascotas(datos,this);

       vMascota.setAdapter(adaptador);
    }

    public void InicializaListaContacto (){

        datos=new ArrayList<com.krivic.mascotitas.Mascotas>();

        datos.add(new com.krivic.mascotitas.Mascotas(R.drawable.masc1,"MascotA",0,0));
        datos.add(new com.krivic.mascotitas.Mascotas(R.drawable.masc2,"MascotB",0,0));
        datos.add(new com.krivic.mascotitas.Mascotas(R.drawable.masc3,"MascotC",0,0));
        datos.add(new com.krivic.mascotitas.Mascotas(R.drawable.masc4,"MascotD",0,0));
        datos.add(new com.krivic.mascotitas.Mascotas(R.drawable.masc5,"MascotE",0,0));
    }

    public void miestrella (View v){
        favoritos = new ArrayList<com.krivic.mascotitas.Mascotas>();
        Intent intent = new Intent(MainActivity.this, DetalleMascota.class);

        for (com.krivic.mascotitas.Mascotas mascotas: datos){
            if(mascotas.getContador()>0){
                favoritos.add(mascotas);
            }
        }
        intent.putExtra(getResources().getString(R.string.Favoritos),favoritos);
        startActivity(intent);
    }
}
