package com.example.proyecto1pdm.tipoevaluador;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto1pdm.ControlBDProyec;
import com.example.proyecto1pdm.R;
import com.example.proyecto1pdm.tipoevaluador.Tipoevaluador;

public class TipoevaluadorEliminarActivity extends Activity {
    EditText editId_tipo_evaluador;
    ControlBDProyec controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipoevaluador_eliminar);
        controlhelper=new ControlBDProyec(this);
        editId_tipo_evaluador=(EditText)findViewById(R.id.editId_tipo_evaluador);
    }

    public void eliminarTipoevaluador(View v){
        String regEliminadas;
        Tipoevaluador tip=new Tipoevaluador();
        tip.setId_tipo_evaluador(editId_tipo_evaluador.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminarTipoevaluador(tip);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
        editId_tipo_evaluador.setText("");
    }
}