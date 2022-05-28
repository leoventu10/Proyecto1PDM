package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;

public class FaseEliminarActivity extends Activity {
    EditText editId_fase;
    ControlBDProyec helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase_eliminar);
        helper = new ControlBDProyec(this);
        editId_fase = (EditText) findViewById(R.id.editId_fase);
    }

    public void eliminarFase(View v){
        String regEliminadas;
        Fase fase = new Fase();
        fase.setId_fase(editId_fase.getText().toString());
        helper.abrir();
        regEliminadas = helper.eliminarFase(fase);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}