package com.example.proyecto1pdm.alumno;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.alumno.Alumno;

public class AlumnoActualizarActivity extends Activity {
    ControlBDProyec helper;
    EditText editCarnet;
    EditText editId_grupo;
    EditText editId_plan_estudio;
    EditText editNombres_alumno;
    EditText editApellidos_alumno;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_actualizar);
        helper = new ControlBDProyec(this);
        editCarnet = (EditText) findViewById(R.id.editCarnet);
        editId_grupo = (EditText) findViewById(R.id.editId_grupo);
        editId_plan_estudio = (EditText) findViewById(R.id.editId_plan_estudio);
        editNombres_alumno = (EditText) findViewById(R.id.editNombres_alumno);
        editApellidos_alumno = (EditText) findViewById(R.id.editApellidos_alumno);
    }
    public void actualizarAlumno(View v) {
        Alumno alumno = new Alumno();
        alumno.setCarnet(editCarnet.getText().toString());
        alumno.setId_grupo(editId_grupo.getText().toString());
        alumno.setId_plan_estudio(editId_plan_estudio.getText().toString());
        alumno.setNombres_alumno(editNombres_alumno.getText().toString());
        alumno.setApellidos_alumno(editApellidos_alumno.getText().toString());
        helper.abrir();
        String estado = helper.actualizarAlumno(alumno);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCarnet.setText("");
        editId_grupo.setText("");
        editId_plan_estudio.setText("");
        editNombres_alumno.setText("");
        editApellidos_alumno.setText("");
    }
}