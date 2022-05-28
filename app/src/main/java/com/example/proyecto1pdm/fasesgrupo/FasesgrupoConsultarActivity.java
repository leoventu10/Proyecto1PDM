package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;

public class FasesgrupoConsultarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_fase_grupo;
    EditText editId_grupo;
    EditText editId_fase;
    EditText editFecha_asignacion;
    EditText editFecha_entrega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasesgrupo_consultar);
        helper = new ControlBDProyec(this);

        editId_fase_grupo = (EditText) findViewById(R.id.editId_fase_grupo);
        editId_grupo = (EditText) findViewById(R.id.editId_grupo);
        editId_fase = (EditText) findViewById(R.id.editId_fase);
        editFecha_asignacion = (EditText) findViewById(R.id.editFecha_asignacion);
        editFecha_entrega = (EditText) findViewById((R.id.editFecha_entrega));
    }

    public void consultarFasesgrupo(View v){
        helper.abrir();
        Fasesgrupo fasesgrupo = helper.consultarFasesgrupo(editId_fase_grupo.getText().toString(),
                editId_grupo.getText().toString());
        helper.cerrar();
        if(fasesgrupo==null){
            Toast.makeText(this,"Fase de grupo no encontrado",Toast.LENGTH_LONG).show();
        }
        else {
            editId_fase_grupo.setText(fasesgrupo.getId_fase_grupo());
            editId_grupo.setText(fasesgrupo.getId_grupo());
            editId_fase.setText(fasesgrupo.getId_fase());
            editFecha_asignacion.setText(fasesgrupo.getFecha_asignacion());
            editFecha_entrega.setText(fasesgrupo.getFecha_entrega());
        }
    }
    public void limpiarTexto(View v){
        editId_fase_grupo.setText("");
        editId_grupo.setText("");
        editId_fase.setText("");
        editFecha_asignacion.setText("");
        editFecha_entrega.setText("");
    }
}