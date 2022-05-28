package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.carrera.Carrera;
import com.example.proyecto1pdm.grupo.Grupo;

public class AlumnoEliminarActivity extends Activity {
    EditText editCarnet,editId_grupo,editId_plan_estudio;
    ControlBDProyec controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_eliminar);
        controlhelper=new ControlBDProyec(this);
        editCarnet=(EditText)findViewById(R.id.editCarnet);
        editId_grupo=(EditText)findViewById(R.id.editId_grupo);
        editId_plan_estudio=(EditText)findViewById(R.id.editId_plan_estudio);
    }

    public void eliminarAlumno(View v){
        String regEliminadas;
        Alumno alumno = new Alumno();
        alumno.setCarnet(editCarnet.getText().toString());
        alumno.setId_grupo(editId_grupo.getText().toString());
        alumno.setId_plan_estudio(editId_plan_estudio.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminarAlumno(alumno);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
        editCarnet.setText("");
        editId_grupo.setText("");
        editId_plan_estudio.setText("");
    }
}