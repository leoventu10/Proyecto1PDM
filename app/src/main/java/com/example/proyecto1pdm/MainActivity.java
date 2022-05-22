package com.example.proyecto1pdm;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String[] menu={"Tabla Docente","Menu Tipo Evaluador","LLenar Base de Datos"};
    String[] activities={"DocenteMenuActivity","TipoevaluadorMenuActivity"};
    ControlBDProyec BDhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
        BDhelper=new ControlBDProyec(this);
    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);
        if(position!=2){
            String nombreValue=activities[position];
            try{
                Class<?> clase=Class.forName("com.example.proyecto1pdm."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
            BDhelper.abrir();
            String tost=BDhelper.llenarBDProyec();
            BDhelper.cerrar();
            Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();
        }
    }
}