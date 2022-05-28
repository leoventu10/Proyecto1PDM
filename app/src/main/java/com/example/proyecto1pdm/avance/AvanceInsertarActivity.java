package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;

public class AvanceInsertarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_avance;
    EditText editId_fase_grupo;
    EditText editDetalle_avance;
    EditText editFecha_entrega;
    EditText editObservaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avance_insertar);
        helper = new ControlBDProyec(this);
        editId_avance = (EditText) findViewById(R.id.editId_avance);
        editId_fase_grupo = (EditText) findViewById(R.id.editId_fase_grupo);
        editDetalle_avance = (EditText) findViewById(R.id.editDetalle_avance);
        editFecha_entrega = (EditText) findViewById(R.id.editFecha_entrega);
        editObservaciones = (EditText) findViewById(R.id.editObservaciones);
    }

    public void insertarAvance(View v){
        String id_avance = editId_avance.getText().toString();
        String id_fase_grupo = editId_fase_grupo.getText().toString();
        String detalle_avance = editDetalle_avance.getText().toString();
        String fecha_entrega = editFecha_entrega.getText().toString();
        String observaciones = editObservaciones.getText().toString();
        String regInsertados;

        Avance avance = new Avance();
        avance.setId_avance(id_avance);
        avance.setId_fase_grupo(id_fase_grupo);
        avance.setDetalle_avance(detalle_avance);
        avance.setFecha_entrega(fecha_entrega);
        avance.setObservaciones(observaciones);
        helper.abrir();
        regInsertados = helper.insertarAvance(avance);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editId_avance.setText("");
        editId_fase_grupo.setText("");
        editDetalle_avance.setText("");
        editFecha_entrega.setText("");
        editObservaciones.setText("");
    }
}