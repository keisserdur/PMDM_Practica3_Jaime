package com.example.admin.pmdm_practica3_jaime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.admin.pmdm_practica3_jaime.datos.Persona;
import com.example.admin.pmdm_practica3_jaime.fragmentos.FragmentoDetalle;

public class MainActivity extends AppCompatActivity implements OnFragmentoInteraccionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onInteraccion(Persona dato) {
        FragmentoDetalle fragmento = (FragmentoDetalle) getFragmentManager().
                findFragmentById(R.id.fragment3);
        if (fragmento == null || !fragmento.isInLayout()) {
            //Vertical
            Intent i=new Intent (this,VerContacto.class);
            Bundle b=new Bundle();
            b.putSerializable("datos", dato);
            i.putExtras(b);
            Log.v("SXC", "lanzamos actividad con: "+dato.toString());
            startActivity(i);
        }else{
            //Horizontal
            fragmento.setDato(dato);
        }
    }
}
