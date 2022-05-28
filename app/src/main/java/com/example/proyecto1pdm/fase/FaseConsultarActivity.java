package com.example.proyecto1pdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;

public class FaseConsultarActivity extends Activity {
    ControlBDProyec helper;
    EditText editId_fase;
    EditText editNombre_fase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase_consultar);
        helper = new ControlBDProyec(this);

        editId_fase = (EditText) findViewById(R.id.editId_fase);
        editNombre_fase = (EditText) findViewById(R.id.editNombre_fase);
    }

    public void consultarFase(View v){
        helper.abrir();
        Fase fase = helper.consultarFase(editId_fase.getText().toString());
        helper.cerrar();
        if (fase == null) {
            Toast.makeText(this, "Fase con ID"+editId_fase.getText().toString()+"No eonctrado",
                    Toast.LENGTH_LONG).show();
        }
        else {
            editNombre_fase.setText(fase.getNombre_fase());
        }
    }

    public void limpiarTexto(View v){
        editId_fase.setText("");
        editNombre_fase.setText("");
    }
}