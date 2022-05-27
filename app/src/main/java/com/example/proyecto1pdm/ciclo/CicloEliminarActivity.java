package com.example.proyecto1pdm.ciclo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.ciclo.Ciclo;

public class CicloEliminarActivity extends Activity {
    EditText editId_ciclo;
    ControlBDProyec controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_eliminar);
        controlhelper=new ControlBDProyec(this);
        editId_ciclo=(EditText)findViewById(R.id.editId_ciclo);
    }

    public void eliminarCiclo(View v){
        String regEliminadas;
        Ciclo ciclo=new Ciclo();
        ciclo.setId_ciclo(editId_ciclo.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminarCiclo(ciclo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
        editId_ciclo.setText("");
    }
}