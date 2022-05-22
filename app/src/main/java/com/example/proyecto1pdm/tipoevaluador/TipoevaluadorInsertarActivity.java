package com.example.proyecto1pdm.tipoevaluador;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.tipoevaluador.Tipoevaluador;

public class TipoevaluadorInsertarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_tipo_evaluador;
    EditText editTipo_evaluador;
    EditText editDescripcion;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipoevaluador_insertar);
        helper = new ControlBDProyec(this);
        editId_tipo_evaluador = (EditText) findViewById(R.id.editId_tipo_evaluador);
        editTipo_evaluador = (EditText) findViewById(R.id.editTipo_evaluador);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
    }
    public void insertarTipoevaluador(View v) {
        String id_tipo_evaluador=editId_tipo_evaluador.getText().toString();
        String tipo_evaluador=editTipo_evaluador.getText().toString();
        String descripcion=editDescripcion.getText().toString();
        String regInsertados;
        Tipoevaluador tip=new Tipoevaluador();
        tip.setId_tipo_evaluador(id_tipo_evaluador);
        tip.setTipo_evaluador(tipo_evaluador);
        tip.setDescripcion(descripcion);
        helper.abrir();
        regInsertados=helper.insertarTipoevaluador(tip);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_tipo_evaluador.setText("");
        editTipo_evaluador.setText("");
        editDescripcion.setText("");
    }
}