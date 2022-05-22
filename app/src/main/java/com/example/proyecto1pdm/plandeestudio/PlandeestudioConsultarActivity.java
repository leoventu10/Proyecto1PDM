package com.example.proyecto1pdm.plandeestudio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.plandeestudio.Plandeestudio;

public class PlandeestudioConsultarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_plan_estudio;
    EditText editAnio_plan_estudio;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plandeestudio_consultar);
        helper = new ControlBDProyec(this);
        editId_plan_estudio = (EditText) findViewById(R.id.editId_plan_estudio);
        editAnio_plan_estudio = (EditText) findViewById(R.id.editAnio_plan_estudio);
    }
    public void consultarPlandeestudios(View v) {
        helper.abrir();
        Plandeestudio plan = helper.consultarPlandeestudio(editId_plan_estudio.getText().toString());
        helper.cerrar();
        if(plan == null)
            Toast.makeText(this, "El plan de estudio " + editId_plan_estudio.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editAnio_plan_estudio.setText(plan.getAnio_plan_estudio());
        }
    }
    public void limpiarTexto(View v){
        editId_plan_estudio.setText("");
        editAnio_plan_estudio.setText("");
    }
}