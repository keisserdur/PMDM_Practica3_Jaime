package com.example.admin.pmdm_practica3_jaime.fragmentos;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.admin.pmdm_practica3_jaime.OnFragmentoInteraccionListener;
import com.example.admin.pmdm_practica3_jaime.R;
import com.example.admin.pmdm_practica3_jaime.adapter.Adaptador;
import com.example.admin.pmdm_practica3_jaime.datos.Persona;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 03/12/2015.
 */
public class FragmentoList extends Fragment {

    private ArrayList<Persona> l;
    private View fragView;
    private ListView lv;
    private Adaptador ad;
    private OnFragmentoInteraccionListener listener;

    public FragmentoList() {
        l=new ArrayList<Persona>();
        List telf=new ArrayList<String>();
        telf.add("35");
        telf.add("38");
        Persona p=new Persona(0, "Tomas", telf);
        l.add(p);
        p=new Persona(1, "Carmen", telf);
        l.add(p);
        p=new Persona(2, "Juan", telf);
        l.add(p);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragView= inflater.inflate(R.layout.fragment_list, container, false);

        ini();

        return fragView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentoInteraccionListener){
            listener= (OnFragmentoInteraccionListener) context;
        }else{
            throw new ClassCastException("Solo acepto OnFragmentoInteraccionListener");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnFragmentoInteraccionListener){
            listener= (OnFragmentoInteraccionListener) activity;
        }else{
            throw new ClassCastException("Solo acepto OnFragmentoInteraccionListener");
        }
    }

    private void ini(){
        lv= (ListView) fragView.findViewById(R.id.listView);
        ad=new Adaptador(this.getActivity(),l);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Ahora lanzamos los tostada desde la actividad
                // Toast.makeText(FragmentoListView.this.getActivity(), "position " + position, Toast.LENGTH_LONG).show();
                listener.onInteraccion(l.get(position));
            }
        });
        lv.setAdapter(ad);
    }

}
