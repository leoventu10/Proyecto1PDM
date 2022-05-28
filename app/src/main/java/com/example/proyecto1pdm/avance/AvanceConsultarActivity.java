package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;

public class AvanceConsultarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_avance;
    EditText editId_fase_grupo;
    EditText editDetalle_avance;
    EditText editFecha_entrega;
    EditText editObservaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avance_consultar);
        helper = new ControlBDProyec(this);
        editId_avance = (EditText) findViewById(R.id.editId_avance);
        editId_fase_grupo = (EditText) findViewById(R.id.editId_fase_grupo);
        editDetalle_avance = (EditText) findViewById(R.id.editDetalle_avance);
        editFecha_entrega = (EditText) findViewById(R.id.editFecha_entrega);
        editObservaciones = (EditText) findViewById(R.id.editObservaciones);
    }
    public void consultarAvance(View v){
        helper.abrir();
        Avance avance = helper.consultarAvance(editId_avance.getText().toString());
        helper.cerrar();
        if (avance==null){
            Toast.makeText(this, "Avance con el id"+editId_avance.getText().toString()+" no encontrado",
                    Toast.LENGTH_LONG).show();
        }
        else{
            editId_fase_grupo.setText(avance.getId_fase_grupo());
            editDetalle_avance.setText(avance.getDetalle_avance());
            editFecha_entrega.setText(avance.getFecha_entrega());
            editObservaciones.setText(avance.getObservaciones());
        }
    }
    public void limpiarTexto(View v){
        editId_avance.setText("");
        editId_fase_grupo.setText("");
        editDetalle_avance.setText("");
        editFecha_entrega.setText("");
        editObservaciones.setText("");
    }
}