package com.example.proyecto1pdm.plandeestudio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.plandeestudio.Plandeestudio;

public class PlandeestudioInsertarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_plan_estudio;
    EditText editAnio_plan_estudio;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plandeestudio_insertar);
        helper = new ControlBDProyec(this);
        editId_plan_estudio = (EditText) findViewById(R.id.editId_plan_estudio);
        editAnio_plan_estudio = (EditText) findViewById(R.id.editAnio_plan_estudio);
    }
    public void insertarPlandeestudio(View v) {
        String id_plan_estudio=editId_plan_estudio.getText().toString();
        String anio_plan_estudio=editAnio_plan_estudio.getText().toString();
        String regInsertados;
        Plandeestudio plan = new Plandeestudio();
        plan.setId_plan_estudio(id_plan_estudio);
        plan.setAnio_plan_estudio(anio_plan_estudio);
        helper.abrir();
        regInsertados=helper.insertarPlandeestudios(plan);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_plan_estudio.setText("");
        editAnio_plan_estudio.setText("");
    }
}