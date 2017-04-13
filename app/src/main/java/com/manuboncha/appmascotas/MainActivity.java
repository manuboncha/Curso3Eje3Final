package com.manuboncha.appmascotas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;

    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Manipular Toolbar - actionbar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionbar_personal);
        //cambiar el color del texto del titulo
        miActionBar.setTitleTextColor(getResources().getColor(R.color.colorTituloToolbar));
        //agregar titulo al Toolbar
        miActionBar.setTitle(getResources().getText(R.string.app_name_personalizada));
        setSupportActionBar(miActionBar);


        listaMascotas = (RecyclerView) findViewById(R.id.rv_reciclador);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializaAdaptador();

        // Boton Favoritos ========
        ImageView imgBtnFavoritos = (ImageView) findViewById(R.id.imgv_favorito);
        imgBtnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Mostrar Favoritos", Snackbar.LENGTH_LONG).show();
                Intent intent2 = new Intent(MainActivity.this, Mascota_favorita.class);
                startActivity(intent2);
            }
        });

        //Boton FloatingActionButton
        FloatingActionButton miFab = (FloatingActionButton) findViewById(R.id.fab_miBotonF);
        miFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Mas avanzado con un boton dentro del snackbar y muestra un mensaje en el logcat
                Snackbar.make(v,getResources().getString(R.string.app_msn_toast1),Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.app_snackbar_btn_accion), new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR","Click en boton de Snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();

            }
        });
    }

    public MascotaAdaptador adaptador;
    public void inicializaAdaptador(){
        adaptador =  new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.perro_1, "Pulgoso", 5));
        mascotas.add(new Mascotas(R.drawable.perro_2, "Scooby", 3));
        mascotas.add(new Mascotas(R.drawable.perro_3, "Snopy", 1));
        mascotas.add(new Mascotas(R.drawable.perro_4, "Lokcy", 9));
        mascotas.add(new Mascotas(R.drawable.perro_5, "Torso", 2));
        mascotas.add(new Mascotas(R.drawable.perro_6, "Boxer", 1));
        mascotas.add(new Mascotas(R.drawable.perro_8, "Sky", 81));

    }



}
