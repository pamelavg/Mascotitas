package com.krivic.mascotitas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Adaptador_Mascotas extends RecyclerView.Adapter<Adaptador_Mascotas.MascotasViewHolder>{
    ArrayList<com.krivic.mascotitas.Mascotas> datos;
    Activity activity;
    int huesolike;

    public Adaptador_Mascotas(ArrayList<com.krivic.mascotitas.Mascotas> contactos, Activity activity){

        this.datos=contactos;
        this.activity=activity;
    }


    @Override
    public MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mascotas,parent,false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotasViewHolder mascotasViewHolder,final int position) {
        final com.krivic.mascotitas.Mascotas mascotas= datos.get(position);
        mascotasViewHolder.imgfoto.setImageResource(mascotas.getImgfoto());
        mascotasViewHolder.cvnombre.setText(mascotas.getNombre());
        mascotasViewHolder.cvconteo.setText(""+ mascotas.getHuesolike());
        mascotasViewHolder.btnlike.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"I Like " + mascotas.getNombre(),Toast.LENGTH_SHORT).show();
                mascotas.setContador();
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgfoto;
        private TextView cvnombre;
        private ImageView btnlike;
        private TextView cvconteo;

        public MascotasViewHolder(View itemView) {
            super(itemView);
            imgfoto=(ImageView) itemView.findViewById(R.id.imgfoto);
            cvnombre=(TextView) itemView.findViewById(R.id.cvnombre);
            btnlike=(ImageView) itemView.findViewById(R.id.btnlike);
            cvconteo=(TextView) itemView.findViewById(R.id.cvconteo);

        }


    }


}
