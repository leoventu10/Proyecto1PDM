package com.example.proyecto1pdm.docente;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.docente.Docente;

public class DocenteInsertarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_docente;
    EditText editNombre_docente;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_insertar);
        helper = new ControlBDProyec(this);
        editId_docente = (EditText) findViewById(R.id.editId_docente);
        editNombre_docente = (EditText) findViewById(R.id.editNombre_docente);
    }
    public void insertarDocente(View v) {
        String id_docente=editId_docente.getText().toString();
        String nombre_docente=editNombre_docente.getText().toString();
        String regInsertados;
        Docente docente=new Docente();
        docente.setId_docente(id_docente);
        docente.setNombre_docente(nombre_docente);
        helper.abrir();
        regInsertados=helper.insertarDocente(docente);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_docente.setText("");
        editNombre_docente.setText("");
    }
}