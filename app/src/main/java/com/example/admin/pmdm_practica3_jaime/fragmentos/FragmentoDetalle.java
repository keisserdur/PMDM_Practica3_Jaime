package com.example.admin.pmdm_practica3_jaime.fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.pmdm_practica3_jaime.R;
import com.example.admin.pmdm_practica3_jaime.datos.Persona;

/**
 * Created by Admin on 03/12/2015.
 */
public class FragmentoDetalle extends Fragment {
    private Persona dato;
    private View frag;
    private TextView tv,tv2,tv3;
    private ImageView iv;

    public FragmentoDetalle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        frag= inflater.inflate(R.layout.fragment_detalles, container, false);
        tv= (TextView) frag.findViewById(R.id.textView2);
        tv3= (TextView) frag.findViewById(R.id.textView4);
        iv= (ImageView) frag.findViewById(R.id.imageView2);
        return frag;
    }

    public void setDato(Persona dato){
        this.dato=dato;
        if(dato!=null) {
            tv.setText(dato.getNombre());
            tv3.setText(dato.getAllTelefonos());
        }
    }
}
