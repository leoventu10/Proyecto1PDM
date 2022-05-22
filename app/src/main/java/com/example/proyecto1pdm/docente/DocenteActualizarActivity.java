package com.example.proyecto1pdm.docente;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.docente.Docente;

public class DocenteActualizarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_docente;
    EditText editNombre_docente;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_actualizar);
        helper = new ControlBDProyec(this);
        editId_docente = (EditText) findViewById(R.id.editId_docente);
        editNombre_docente = (EditText) findViewById(R.id.editNombre_docente);
    }
    public void actualizarDocente(View v) {
        Docente alumno = new Docente();
        alumno.setId_docente(editId_docente.getText().toString());
        alumno.setNombre_docente(editNombre_docente.getText().toString());
        helper.abrir();
        String estado = helper.actualizarDocente(alumno);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_docente.setText("");
        editNombre_docente.setText("");
    }
}