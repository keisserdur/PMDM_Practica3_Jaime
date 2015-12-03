package com.example.admin.pmdm_practica3_jaime.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.pmdm_practica3_jaime.R;
import com.example.admin.pmdm_practica3_jaime.datos.Persona;

import java.util.ArrayList;

/**
 * Created by Admin on 03/12/2015.
 */

public class Adaptador extends ArrayAdapter<Persona> {

    private Context contexto;
    private int recurso;
    private ArrayList<Persona> lista;
    private TextView tv,tv2;

    private LayoutInflater i;

    public Adaptador(Context contexto, ArrayList<Persona> lista) {
        super(contexto, R.layout.item,lista);

        this.contexto=contexto;
        this.recurso=R.layout.item;
        this.lista=lista;

        i = (LayoutInflater) contexto.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Estando mal optimizado
        // convertView = i.inflate(recurso, null);
        ViewHolder vh;
        if (convertView==null){

            convertView = i.inflate(recurso, null);
            tv = (TextView) convertView.findViewById(R.id.textView);

            vh=new ViewHolder();
            vh.tv=tv;

            convertView.setTag(vh);
        }else{
            vh= (ViewHolder) convertView.getTag();
        }

        tv.setText(lista.get(position).getNombre());

        return convertView;

    }

    static class ViewHolder{
        private TextView tv;
    }

}

