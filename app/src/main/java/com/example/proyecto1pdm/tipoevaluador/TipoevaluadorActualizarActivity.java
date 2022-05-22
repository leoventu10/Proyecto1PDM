package com.example.proyecto1pdm.tipoevaluador;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.tipoevaluador.Tipoevaluador;

public class TipoevaluadorActualizarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_tipo_evaluador;
    EditText editTipo_evaluador;
    EditText editDescripcion;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipoevaluador_actualizar);
        helper = new ControlBDProyec(this);
        editId_tipo_evaluador = (EditText) findViewById(R.id.editId_tipo_evaluador);
        editTipo_evaluador = (EditText) findViewById(R.id.editTipo_evaluador);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
    }
    public void actualizarTipoevaluador(View v) {
        Tipoevaluador tip = new Tipoevaluador();
        tip.setId_tipo_evaluador(editId_tipo_evaluador.getText().toString());
        tip.setTipo_evaluador(editTipo_evaluador.getText().toString());
        tip.setDescripcion(editDescripcion.getText().toString());
        helper.abrir();
        String estado = helper.actualizarTipoevaluador(tip);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_tipo_evaluador.setText("");
        editTipo_evaluador.setText("");
        editDescripcion.setText("");
    }
}