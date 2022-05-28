package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GrupoInsertarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_grupo;
    EditText editId_ciclo;
    EditText editId_carrera;
    EditText editFecha_creacion;
    EditText editFecha_modificacion;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_insertar);
        helper = new ControlBDProyec(this);
        editId_grupo = (EditText) findViewById(R.id.editId_grupo);
        editId_ciclo = (EditText) findViewById(R.id.editId_ciclo);
        editId_carrera = (EditText) findViewById(R.id.editId_carrera);
        editFecha_creacion = (EditText) findViewById(R.id.editFecha_creacion);
        editFecha_modificacion = (EditText) findViewById(R.id.editFecha_modificacion);
    }
    public void insertarGrupo(View v) {
        String regInsertados;
        String id_grupo = editId_grupo.getText().toString();
        String id_ciclo = editId_ciclo.getText().toString();
        String id_carrera = editId_carrera.getText().toString();
        String fecha_creacion = editFecha_creacion.getText().toString();
        String fecha_modificacion = editFecha_modificacion.getText().toString();
        Grupo grupo = new Grupo();
        grupo.setId_grupo(id_grupo);
        grupo.setId_ciclo(id_ciclo);
        grupo.setId_carrera(id_carrera);
        grupo.setFecha_creacion(fecha_creacion);
        grupo.setFecha_modificacion(fecha_modificacion);
        helper.abrir();
        regInsertados=helper.insertarGrupo(grupo);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_grupo.setText("");
        editId_ciclo.setText("");
        editId_carrera.setText("");
        editFecha_creacion.setText("");
        editFecha_modificacion.setText("");
    }
}