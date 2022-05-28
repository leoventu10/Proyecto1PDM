package com.example.proyecto1pdm.alumno;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.alumno.Alumno;

public class AlumnoInsertarActivity extends Activity {
    ControlBDProyec helper;
    EditText editCarnet;
    EditText editId_grupo;
    EditText editId_plan_estudio;
    EditText editNombres_alumno;
    EditText editApellidos_alumno;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_insertar);
        helper = new ControlBDProyec(this);
        editCarnet = (EditText) findViewById(R.id.editCarnet);
        editId_grupo = (EditText) findViewById(R.id.editId_grupo);
        editId_plan_estudio = (EditText) findViewById(R.id.editId_plan_estudio);
        editNombres_alumno = (EditText) findViewById(R.id.editNombres_alumno);
        editApellidos_alumno = (EditText) findViewById(R.id.editApellidos_alumno);
    }
    public void insertarAlumno(View v) {
        String regInsertados;
        String carnet = editCarnet.getText().toString();
        String id_grupo = editId_grupo.getText().toString();
        String id_plan_estudio = editId_plan_estudio.getText().toString();
        String nombres_alumno = editNombres_alumno.getText().toString();
        String apellidos_alumno = editApellidos_alumno.getText().toString();
        Alumno alumno = new Alumno();
        alumno.setCarnet(carnet);
        alumno.setId_grupo(id_grupo);
        alumno.setId_plan_estudio(id_plan_estudio);
        alumno.setNombres_alumno(nombres_alumno);
        alumno.setApellidos_alumno(apellidos_alumno);
        helper.abrir();
        regInsertados=helper.insertarAlumno(alumno);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCarnet.setText("");
        editId_grupo.setText("");
        editId_plan_estudio.setText("");
        editNombres_alumno.setText("");
        editApellidos_alumno.setText("");
    }
}