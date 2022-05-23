package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CarreraEliminarActivity extends Activity {
    EditText editId_carrera,editId_plan_estudio;
    ControlBDProyec controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_eliminar);
        controlhelper=new ControlBDProyec(this);
        editId_carrera=(EditText)findViewById(R.id.editId_carrera);
        editId_plan_estudio=(EditText)findViewById(R.id.editId_plan_estudio);
    }

    public void eliminarCarrera(View v){
        String regEliminadas;
        Carrera carr=new Carrera();
        carr.setId_carrera(editId_carrera.getText().toString());
        carr.setId_plan_estudio(editId_plan_estudio.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminarCarrera(carr);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
        editId_carrera.setText("");
        editId_plan_estudio.setText("");
    }
}