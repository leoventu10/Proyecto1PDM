package com.example.proyecto1pdm.carrera;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.carrera.Carrera;

public class CarreraActualizarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_carrera;
    EditText editId_plan_estudio;
    EditText editNombre_carrera;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_actualizar);
        helper = new ControlBDProyec(this);
        editId_carrera = (EditText) findViewById(R.id.editId_carrera);
        editId_plan_estudio = (EditText) findViewById(R.id.editId_plan_estudio);
        editNombre_carrera = (EditText) findViewById(R.id.editNombre_carrera);
    }
    public void actualizarCarrera(View v) {
        Carrera carr = new Carrera();
        carr.setId_carrera(editId_carrera.getText().toString());
        carr.setId_plan_estudio(editId_plan_estudio.getText().toString());
        carr.setNombre_carrera(editNombre_carrera.getText().toString());
        helper.abrir();
        String estado = helper.actualizarCarrera(carr);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_carrera.setText("");
        editId_plan_estudio.setText("");
        editNombre_carrera.setText("");
    }
}