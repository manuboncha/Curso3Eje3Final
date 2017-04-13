package com.manuboncha.appmascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class Mascota_favorita extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;

    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_favorita);


        //Manipular Toolbar - actionbar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionbar_favorito_personal2);
        //cambiar el color del texto del titulo
        miActionBar.setTitleTextColor(getResources().getColor(R.color.colorTituloToolbar));

        //Ocultar imagen de estrella de favoritos
        miActionBar.findViewById(R.id.imgv_favorito).setVisibility(View.INVISIBLE);
        setSupportActionBar(miActionBar);

        //Activar boton atras del Toolbar o Actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rv_reciclador2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializaAdaptador();
    }

    public MascotaAdaptador adaptador;
    public void inicializaAdaptador(){
        adaptador =  new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.perro_8, "Sky", 81));
        mascotas.add(new Mascotas(R.drawable.perro_4, "Lokcy", 9));
        mascotas.add(new Mascotas(R.drawable.perro_1, "Pulgoso", 5));
        mascotas.add(new Mascotas(R.drawable.perro_2, "Scooby", 3));
        mascotas.add(new Mascotas(R.drawable.perro_5, "Torso", 2));


    }

}
