package com.example.proyecto1pdm.ciclo;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.ciclo.Ciclo;

public class CicloActualizarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_ciclo;
    EditText editNumero_ciclo;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_actualizar);
        helper = new ControlBDProyec(this);
        editId_ciclo = (EditText) findViewById(R.id.editId_ciclo);
        editNumero_ciclo = (EditText) findViewById(R.id.editNumero_ciclo);
    }
    public void actualizarCiclo(View v) {
        Ciclo ciclo = new Ciclo();
        ciclo.setId_ciclo(editId_ciclo.getText().toString());
        ciclo.setNumero_ciclo(Integer.valueOf(editNumero_ciclo.getText().toString()));
        helper.abrir();
        String estado = helper.actualizarCiclo(ciclo);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_ciclo.setText("");
        editNumero_ciclo.setText("");
    }
}