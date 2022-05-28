package com.example.proyecto1pdm;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;

public class FasesgrupoActualizarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_fase_grupo;
    EditText editId_grupo;
    EditText editId_fase;
    EditText editFecha_asignacion;
    EditText editFecha_entrega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasesgrupo_actualizar);
        helper = new ControlBDProyec(this);
        editId_fase_grupo = (EditText) findViewById(R.id.editId_fase_grupo);
        editId_grupo = (EditText) findViewById(R.id.editId_grupo);
        editId_fase = (EditText) findViewById(R.id.editId_fase);
        editFecha_asignacion = (EditText) findViewById(R.id.editFecha_asignacion);
        editFecha_entrega = (EditText) findViewById((R.id.editFecha_entrega));
    }

    public void actualizarFasesgrupo(View v){
        Fasesgrupo fasesgrupo = new Fasesgrupo();
        fasesgrupo.setId_fase_grupo(editId_fase_grupo.getText().toString());
        fasesgrupo.setId_grupo(editId_grupo.getText().toString());
        fasesgrupo.setId_fase(editId_fase.getText().toString());
        fasesgrupo.setFecha_asignacion(editFecha_asignacion.getText().toString());
        fasesgrupo.setFecha_entrega(editFecha_entrega.getText().toString());

        helper.abrir();
        String estado = helper.actualizarFasesgrupo(fasesgrupo);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editId_fase_grupo.setText("");
        editId_grupo.setText("");
        editId_fase.setText("");
        editFecha_asignacion.setText("");
        editFecha_entrega.setText("");
    }
}