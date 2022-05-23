package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CarreraInsertarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_carrera;
    EditText editId_plan_estudio;
    EditText editNombre_carrera;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_insertar);
        helper = new ControlBDProyec(this);
        editId_carrera = (EditText) findViewById(R.id.editId_carrera);
        editId_plan_estudio = (EditText) findViewById(R.id.editId_plan_estudio);
        editNombre_carrera = (EditText) findViewById(R.id.editNombre_carrera);
    }
    public void insertarCarrera(View v) {
        String regInsertados;
        String id_carrera=editId_carrera.getText().toString();
        String id_plan_estudio=editId_plan_estudio.getText().toString();
        String nombre_carrera=editNombre_carrera.getText().toString();
        Carrera carr= new Carrera();
        carr.setId_carrera(id_carrera);
        carr.setId_plan_estudio(id_plan_estudio);
        carr.setNombre_carrera(nombre_carrera);
        helper.abrir();
        regInsertados=helper.insertarCarrera(carr);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_carrera.setText("");
        editId_plan_estudio.setText("");
        editNombre_carrera.setText("");
    }
}