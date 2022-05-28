package com.example.proyecto1pdm.grupo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.grupo.Grupo;

public class GrupoActualizarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_grupo;
    EditText editId_ciclo;
    EditText editId_carrera;
    EditText editFecha_creacion;
    EditText editFecha_modificacion;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_actualizar);
        helper = new ControlBDProyec(this);
        editId_grupo = (EditText) findViewById(R.id.editId_grupo);
        editId_ciclo = (EditText) findViewById(R.id.editId_ciclo);
        editId_carrera = (EditText) findViewById(R.id.editId_carrera);
        editFecha_creacion = (EditText) findViewById(R.id.editFecha_creacion);
        editFecha_modificacion = (EditText) findViewById(R.id.editFecha_modificacion);
    }
    public void actualizarGrupo(View v) {
        Grupo grupo = new Grupo();
        grupo.setId_grupo(editId_grupo.getText().toString());
        grupo.setId_ciclo(editId_ciclo.getText().toString());
        grupo.setId_carrera(editId_carrera.getText().toString());
        grupo.setFecha_creacion(editFecha_creacion.getText().toString());
        grupo.setFecha_modificacion(editFecha_modificacion.getText().toString());
        helper.abrir();
        String estado = helper.actualizarGrupo(grupo);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_grupo.setText("");
        editId_ciclo.setText("");
        editId_carrera.setText("");
        editFecha_creacion.setText("");
        editFecha_modificacion.setText("");
    }
}