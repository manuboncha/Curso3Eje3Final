package com.manuboncha.appmascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by KYONET on 27/03/2017.
 */



public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

     List<Mascotas> list_mascotas;
     Activity activity;

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        //Declarar views
        public ImageView ivFotoCV;
        public TextView tvNombreCV;
        public TextView tvVotosCV;
        public Mascotas mascota2;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            ivFotoCV   = (ImageView) itemView.findViewById(R.id.img_foto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tv_nombre);
            tvVotosCV  = (TextView) itemView.findViewById(R.id.tv_cantidad_votos);

        }
    }


    public MascotaAdaptador(List<Mascotas> list_mascotas, Activity activity) {
        this.list_mascotas = list_mascotas;
        this.activity = activity;
    }



    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder viewHolder, int position) {
        viewHolder.mascota2 = list_mascotas.get(position);
        viewHolder.ivFotoCV.setImageResource( viewHolder.mascota2.getFoto());
        viewHolder.tvNombreCV.setText( viewHolder.mascota2.getNombre());
        viewHolder.tvVotosCV.setText(String.valueOf( viewHolder.mascota2.getCalificacion()));

        viewHolder.ivFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view,  viewHolder.mascota2.getNombre(),Snackbar.LENGTH_SHORT).show();

                //viewHolder.mascotas
                Intent intent = new Intent(activity, Mascota_favorita.class);
                intent.putExtra("nombreMascota",  viewHolder.mascota2.getNombre());
                intent.putExtra("fotoMascota",  viewHolder.mascota2.getFoto());
                intent.putExtra("favoritoMascota",  viewHolder.mascota2.getCalificacion());
                activity.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() { //Devuelve la cantidad de elementos
        return list_mascotas.size();
    }


}
