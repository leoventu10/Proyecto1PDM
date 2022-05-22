package com.example.proyecto1pdm.plandeestudio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.plandeestudio.Plandeestudio;

public class PlandeestudioEliminarActivity extends Activity {
    EditText editId_plan_estudio;
    ControlBDProyec controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plandeestudio_eliminar);
        controlhelper=new ControlBDProyec(this);
        editId_plan_estudio=(EditText)findViewById(R.id.editId_plan_estudio);
    }

    public void eliminarPlandeestudio(View v){
        String regEliminadas;
        Plandeestudio plan = new Plandeestudio();
        plan.setId_plan_estudio(editId_plan_estudio.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminarPlandeestudio(plan);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
        editId_plan_estudio.setText("");
    }
}