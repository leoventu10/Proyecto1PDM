package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;

public class FaseInsertarActivity extends Activity {
    ControlBDProyec helper;
    EditText editIdFase;
    EditText editNombreFase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase_insertar);
        helper = new ControlBDProyec(this);
        editIdFase = (EditText) findViewById(R.id.editId_fase);
        editNombreFase = (EditText) findViewById(R.id.editNombre_fase);
    }

    public void insertarFase(View v){
        String id_fase = editIdFase.getText().toString();
        String nombre_fase = editNombreFase.getText().toString();
        String regInsertados;

        Fase fase = new Fase();
        fase.setId_fase(id_fase);
        fase.setNombre_fase(nombre_fase);
        helper.abrir();
        regInsertados = helper.insertarFase(fase);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editIdFase.setText("");
        editNombreFase.setText("");
    }
}