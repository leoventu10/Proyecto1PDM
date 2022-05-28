package com.example.proyecto1pdm;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;

public class AvanceActualizarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_avance;
    EditText editId_fase_grupo;
    EditText editDetalle_avance;
    EditText editFecha_entrega;
    EditText editObservaciones;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avance_actualizar);
        helper = new ControlBDProyec(this);
        editId_avance = (EditText) findViewById(R.id.editId_avance);
        editId_fase_grupo = (EditText) findViewById(R.id.editId_fase_grupo);
        editDetalle_avance = (EditText) findViewById(R.id.editDetalle_avance);
        editFecha_entrega = (EditText) findViewById(R.id.editFecha_entrega);
        editObservaciones = (EditText) findViewById(R.id.editObservaciones);
    }
    public void actualizarAvance(View v){
        Avance avance = new Avance();
        avance.setId_avance(editId_avance.getText().toString());
        avance.setId_fase_grupo(editId_fase_grupo.getText().toString());
        avance.setDetalle_avance(editDetalle_avance.getText().toString());
        avance.setFecha_entrega(editFecha_entrega.getText().toString());
        avance.setObservaciones(editObservaciones.getText().toString());

        helper.abrir();
        String estado = helper.actualizarAvance(avance);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editId_avance.setText("");
        editId_fase_grupo.setText("");
        editDetalle_avance.setText("");
        editFecha_entrega.setText("");
        editObservaciones.setText("");
    }
}