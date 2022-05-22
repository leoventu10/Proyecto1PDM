package com.example.proyecto1pdm.docente;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.docente.Docente;

public class DocenteEliminarActivity extends Activity {
    EditText editId_docente;
    ControlBDProyec controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_eliminar);
        controlhelper=new ControlBDProyec(this);
        editId_docente=(EditText)findViewById(R.id.editId_docente);
    }

    public void eliminarDocente(View v){
        String regEliminadas;
        Docente docente=new Docente();
        docente.setId_docente(editId_docente.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminarDocente(docente);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
        editId_docente.setText("");
    }
}
