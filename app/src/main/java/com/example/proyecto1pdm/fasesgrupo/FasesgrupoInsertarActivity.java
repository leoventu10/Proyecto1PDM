package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;

public class FasesgrupoInsertarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_fase_grupo;
    EditText editId_grupo;
    EditText editId_fase;
    EditText editFecha_asignacion;
    EditText editFecha_entrega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasesgrupo_insertar);
        helper = new ControlBDProyec(this);
        editId_fase_grupo = (EditText) findViewById(R.id.editId_fase_grupo);
        editId_grupo = (EditText) findViewById(R.id.editId_grupo);
        editId_fase = (EditText) findViewById(R.id.editId_fase);
        editFecha_asignacion = (EditText) findViewById(R.id.editFecha_asignacion);
        editFecha_entrega = (EditText) findViewById((R.id.editFecha_entrega));
    }

    public void insertarFasesgrupo(View v){
        String id_fase_grupo = editId_fase_grupo.getText().toString();
        String id_grupo = editId_grupo.getText().toString();
        String id_fase = editId_fase.getText().toString();
        String fecha_asignacion = editFecha_asignacion.getText().toString();
        String fecha_entrega = editFecha_entrega.getText().toString();
        String regInsertados;

        Fasesgrupo fasesgrupo = new Fasesgrupo();
        fasesgrupo.setId_fase_grupo(id_fase_grupo);
        fasesgrupo.setId_grupo(id_grupo);
        fasesgrupo.setId_fase(id_fase);
        fasesgrupo.setFecha_asignacion(fecha_asignacion);
        fasesgrupo.setFecha_entrega(fecha_entrega);
        helper.abrir();
        regInsertados = helper.insertarFasesgrupo(fasesgrupo);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();

    }

    public void limpiarTexto(View v){
        editId_fase_grupo.setText("");
        editId_grupo.setText("");
        editId_fase.setText("");
        editFecha_asignacion.setText("");
        editFecha_entrega.setText("");
    }
}