package com.example.proyecto1pdm.grupo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.carrera.Carrera;

public class GrupoEliminarActivity extends Activity {
    EditText editId_grupo,editId_ciclo,editId_carrera;
    ControlBDProyec controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_eliminar);
        controlhelper=new ControlBDProyec(this);
        editId_grupo=(EditText)findViewById(R.id.editId_grupo);
        editId_ciclo=(EditText)findViewById(R.id.editId_ciclo);
        editId_carrera=(EditText)findViewById(R.id.editId_carrera);
    }

    public void eliminarGrupo(View v){
        String regEliminadas;
        Grupo grup = new Grupo();
        grup.setId_grupo(editId_grupo.getText().toString());
        grup.setId_ciclo(editId_ciclo.getText().toString());
        grup.setId_carrera(editId_carrera.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminarGrupo(grup);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
        editId_grupo.setText("");
        editId_ciclo.setText("");
        editId_carrera.setText("");
    }
}