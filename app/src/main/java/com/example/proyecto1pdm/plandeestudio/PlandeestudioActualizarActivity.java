package com.example.proyecto1pdm.plandeestudio;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.plandeestudio.Plandeestudio;

public class PlandeestudioActualizarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_plan_estudio;
    EditText editAnio_plan_estudio;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plandeestudio_actualizar);
        helper = new ControlBDProyec(this);
        editId_plan_estudio = (EditText) findViewById(R.id.editId_plan_estudio);
        editAnio_plan_estudio = (EditText) findViewById(R.id.editAnio_plan_estudio);
    }
    public void actualizarPlandeestudio(View v) {
        Plandeestudio plan = new Plandeestudio();
        plan.setId_plan_estudio(editId_plan_estudio.getText().toString());
        plan.setAnio_plan_estudio(editAnio_plan_estudio.getText().toString());
        helper.abrir();
        String estado = helper.actualizarPlandeestudios(plan);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_plan_estudio.setText("");
        editAnio_plan_estudio.setText("");
    }
}