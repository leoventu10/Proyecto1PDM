package com.example.proyecto1pdm.carrera;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.carrera.Carrera;

public class CarreraConsultarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_carrera;
    EditText editId_plan_estudio;
    EditText editNombre_carrera;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_consultar);
        helper = new ControlBDProyec(this);
        editId_carrera = (EditText) findViewById(R.id.editId_carrera);
        editId_plan_estudio = (EditText) findViewById(R.id.editId_plan_estudio);
        editNombre_carrera = (EditText) findViewById(R.id.editNombre_carrera);
    }
    public void consultarCarrera(View v) {
        helper.abrir();
        Carrera carr = helper.consultarCarrera(editId_carrera.getText().toString(),editId_plan_estudio.getText().toString());
        helper.cerrar();
        if(carr == null)
            Toast.makeText(this, "La Carrera " + editId_carrera.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombre_carrera.setText(carr.getNombre_carrera());
        }
    }
    public void limpiarTexto(View v){
        editId_carrera.setText("");
        editId_plan_estudio.setText("");
        editNombre_carrera.setText("");
    }
}