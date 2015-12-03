package com.example.admin.pmdm_practica3_jaime;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.pmdm_practica3_jaime.datos.Persona;
import com.example.admin.pmdm_practica3_jaime.fragmentos.FragmentoDetalle;

/**
 * Created by Admin on 03/12/2015.
 */
public class VerContacto extends Activity {
    private Persona dato;
    private String valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("SXC","onCreate");
        valor=null;
        if(savedInstanceState!=null){
            Log.v("SXC","onsave!=null");
            valor=savedInstanceState.getString("valor");
        }

        if(valor==null){
            Log.v("SXC","valor==null");
            setContentView(R.layout.activity_contacto);
            dato = (Persona) getIntent().getExtras().getSerializable("datos");
            FragmentoDetalle fragmento = (FragmentoDetalle) getFragmentManager().
                    findFragmentById(R.id.fragment4);
            fragmento.setDato(dato);
        }else {
            Log.v("SXC","valor!=null");
            //Regresar el valor a la actividad anterior
            //Con un staractivityForResult
            //Y le pasamos valor
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("valor",dato);
    }
}
