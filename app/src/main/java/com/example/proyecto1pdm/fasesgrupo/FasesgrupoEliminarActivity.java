package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;

public class FasesgrupoEliminarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_fase_grupo;
    EditText editId_grupo;
    EditText editId_fase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasesgrupo_eliminar);
        helper = new ControlBDProyec(this);
        editId_fase_grupo = (EditText) findViewById(R.id.editId_fase_grupo);
        editId_grupo = (EditText) findViewById(R.id.editId_grupo);
        editId_fase = (EditText) findViewById(R.id.editId_fase);
    }
    public void eliminarFasesgrupo(View v){
        String regEliminadas;
        Fasesgrupo fasesgrupo = new Fasesgrupo();
        fasesgrupo.setId_fase_grupo(editId_fase_grupo.getText().toString());
        fasesgrupo.setId_grupo(editId_grupo.getText().toString());
        fasesgrupo.setId_fase(editId_fase.getText().toString());
        helper.abrir();
        regEliminadas = helper.eliminarFasesgrupo(fasesgrupo);
        helper.cerrar();
        Toast.makeText(this,regEliminadas,Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){
        editId_fase_grupo.setText("");
        editId_grupo.setText("");
        editId_fase.setText("");
    }
}