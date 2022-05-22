package com.example.proyecto1pdm.tipoevaluador;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.tipoevaluador.Tipoevaluador;

public class TipoevaluadorConsultarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_tipo_evaluador;
    EditText editTipo_evaluaador;
    EditText editDescripcion;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipoevaluador_consultar);
        helper = new ControlBDProyec(this);
        editId_tipo_evaluador = (EditText) findViewById(R.id.editId_tipo_evaluador);
        editTipo_evaluaador = (EditText) findViewById(R.id.editTipo_evaluador);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
    }
    public void consultarTipoevaluador(View v) {
        helper.abrir();
        Tipoevaluador tip = helper.consultarTipoevaluador(editId_tipo_evaluador.getText().toString());
        helper.cerrar();
        if(tip == null)
            Toast.makeText(this, "El tipo de evaluador " + editId_tipo_evaluador.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editTipo_evaluaador.setText(tip.getTipo_evaluador());
            editDescripcion.setText(tip.getDescripcion());
        }
    }
    public void limpiarTexto(View v){
        editId_tipo_evaluador.setText("");
        editTipo_evaluaador.setText("");
        editDescripcion.setText("");
    }
}