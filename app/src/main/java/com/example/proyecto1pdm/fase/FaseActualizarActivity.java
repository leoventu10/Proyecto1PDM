package com.example.proyecto1pdm;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;

public class FaseActualizarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_fase;
    EditText editNombre_fase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase_actualizar);
        helper = new ControlBDProyec(this);
        editId_fase = (EditText) findViewById(R.id.editId_fase);
        editNombre_fase = (EditText) findViewById(R.id.editNombre_fase);
    }

    public void actualizarFase(View v){
        Fase fase = new Fase();
        fase.setId_fase(editId_fase.getText().toString());
        fase.setNombre_fase(editNombre_fase.getText().toString());
        helper.abrir();
        String estado = helper.actualizarFase(fase);
        helper.cerrar();

        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editId_fase.setText("");
        editNombre_fase.setText("");
    }
}