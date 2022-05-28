package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GrupoConsultarActivity extends Activity {
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
        setContentView(R.layout.activity_grupo_consultar);
        helper = new ControlBDProyec(this);
        editId_grupo = (EditText) findViewById(R.id.editId_grupo);
        editId_ciclo = (EditText) findViewById(R.id.editId_ciclo);
        editId_carrera = (EditText) findViewById(R.id.editId_carrera);
        editFecha_creacion = (EditText) findViewById(R.id.editFecha_creacion);
        editFecha_modificacion = (EditText) findViewById(R.id.editFecha_modificacion);
    }
    public void consultarGrupo(View v) {
        helper.abrir();
        Grupo grupo = helper.consultarGrupo(editId_grupo.getText().toString(),
                editId_ciclo.getText().toString(), editId_carrera.getText().toString());
        helper.cerrar();
        if(grupo == null)
            Toast.makeText(this, "Grupo no registrado",
                    Toast.LENGTH_LONG).show();
        else{
            editFecha_creacion.setText(String.valueOf(grupo.getFecha_creacion()));
            editFecha_modificacion.setText(String.valueOf(grupo.getFecha_modificacion()));
        }
    }
    public void limpiarTexto(View v) {
        editId_grupo.setText("");
        editId_ciclo.setText("");
        editId_carrera.setText("");
        editFecha_creacion.setText("");
        editFecha_modificacion.setText("");
    }
}