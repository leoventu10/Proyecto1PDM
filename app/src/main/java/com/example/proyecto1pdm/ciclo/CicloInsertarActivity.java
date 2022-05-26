package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.carrera.Carrera;

public class CicloInsertarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_ciclo;
    EditText editNumero_ciclo;
    EditText editCiclo_activo;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_insertar);
        helper = new ControlBDProyec(this);
        editId_ciclo = (EditText) findViewById(R.id.editId_ciclo);
        editNumero_ciclo = (EditText) findViewById(R.id.editNumero_ciclo);
        editCiclo_activo = (EditText) findViewById(R.id.editCiclo_activo);
    }
    public void insertarCiclo(View v) {
        String regInsertados;
        String id_ciclo=editId_ciclo.getText().toString();
        int numero_ciclo=Integer.valueOf(editNumero_ciclo.getText().toString());
        String ciclo_activo=editCiclo_activo.getText().toString();
        Ciclo ciclo = new Ciclo();
        ciclo.setId_ciclo(id_ciclo);
        ciclo.setNumero_ciclo(numero_ciclo);
        ciclo.setCiclo_activo(ciclo_activo);
        helper.abrir();
        regInsertados=helper.insertarCiclo(ciclo);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_ciclo.setText("");
        editNumero_ciclo.setText("");
        editCiclo_activo.setText("");
    }
}