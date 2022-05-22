package com.example.proyecto1pdm.docente;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.docente.Docente;

public class DocenteConsultarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_docente;
    EditText editNombre_docente;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_consultar);
        helper = new ControlBDProyec(this);
        editId_docente = (EditText) findViewById(R.id.editId_docente);
        editNombre_docente = (EditText) findViewById(R.id.editNombre_docente);
    }
    public void consultarDocente(View v) {
        helper.abrir();
        Docente docente = helper.consultarDocente(editId_docente.getText().toString());
        helper.cerrar();
        if(docente == null)
            Toast.makeText(this, "Docente con id_docente " + editId_docente.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombre_docente.setText(docente.getNombre_docente());
        }
    }
    public void limpiarTexto(View v){
        editId_docente.setText("");
        editNombre_docente.setText("");
    }
}