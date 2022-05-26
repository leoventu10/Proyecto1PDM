package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.tipoevaluador.Tipoevaluador;

public class CicloConsultarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_ciclo;
    EditText editNumero_ciclo;
    EditText editCiclo_activo;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_consultar);
        helper = new ControlBDProyec(this);
        editId_ciclo = (EditText) findViewById(R.id.editId_ciclo);
        editNumero_ciclo = (EditText) findViewById(R.id.editNumero_ciclo);
        editCiclo_activo = (EditText) findViewById(R.id.editCiclo_activo);
    }
    public void consultarCiclo(View v) {
        helper.abrir();
        Ciclo ciclo = helper.consultarCiclo(editId_ciclo.getText().toString());
        helper.cerrar();
        if(ciclo == null)
            Toast.makeText(this, "El ciclo " + editId_ciclo.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNumero_ciclo.setText(String.valueOf(ciclo.getNumero_ciclo()));
            editCiclo_activo.setText(ciclo.getCiclo_activo());
        }
    }
    public void limpiarTexto(View v){
        editId_ciclo.setText("");
        editNumero_ciclo.setText("");
        editCiclo_activo.setText("");
    }
}