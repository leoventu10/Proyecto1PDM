package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;

public class AvanceEliminarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_avance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avance_eliminar);
        helper = new ControlBDProyec(this);
        editId_avance = (EditText) findViewById(R.id.editId_avance);
    }
    public void eliminarAvance(View v){
        String regEliminadas;
        Avance avance = new Avance();
        avance.setId_avance(editId_avance.getText().toString());
        helper.abrir();
        regEliminadas = helper.eliminarAvance(avance);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}