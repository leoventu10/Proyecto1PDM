package com.example.proyecto1pdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.proyecto1pdm.docente.Docente;
import com.example.proyecto1pdm.tipoevaluador.Tipoevaluador;

public class ControlBDProyec {
    private static final String[]camposDocente = new String [] {"id_docente","nombre_docente"};
    private static final String[]camposTipoevaluador = new String[] {"id_tipo_evaluador","tipo_evaluador","descripcion"};
    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    public ControlBDProyec(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "Proyec1.s3db";
        private static final int VERSION = 1;
        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL("CREATE TABLE docente(id_docente VARCHAR(6) NOT NULL PRIMARY KEY,nombre_docente VARCHAR(50));");
                db.execSQL("CREATE TABLE tipoevaluador(id_tipo_evaluador VARCHAR(6) NOT NULL PRIMARY KEY,tipo_evaluador VARCHAR(30),descripcion VARCHAR(100));");
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
        }
    }
    public void abrir() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return;
    }
    public void cerrar(){
        DBHelper.close();
    }
    /*Codigos de Insercion de Datos a las diferentes Tablas*/
    public String insertarDocente(Docente docente){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues doc = new ContentValues();
        doc.put("id_docente", docente.getId_docente());
        doc.put("nombre_docente", docente.getNombre_docente());
        contador=db.insert("docente", null, doc);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String insertarTipoevaluador(Tipoevaluador tipoevaluador){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues tip = new ContentValues();
        tip.put("id_tipo_evaluador", tipoevaluador.getId_tipo_evaluador());
        tip.put("tipo_evaluador", tipoevaluador.getTipo_evaluador());
        tip.put("descripcion", tipoevaluador.getDescripcion());
        contador=db.insert("tipoevaluador", null, tip);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    /*Codigos de Actualizacion de Datos a las diferentes Tablas*/
    public String actualizarDocente(Docente docente){
        if(verificarIntegridad(docente, 1)){
            String[] id = {docente.getId_docente()};
            ContentValues doc = new ContentValues();
            doc.put("nombre_docente", docente.getNombre_docente());
            db.update("docente", doc, "id_docente = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con Id_Carnet " + docente.getId_docente() + " no existe";
        }
    }
    public String actualizarTipoevaluador(Tipoevaluador tipoevaluador){
        if(verificarIntegridad(tipoevaluador, 2)){
            String[] id = {tipoevaluador.getId_tipo_evaluador()};
            ContentValues cv = new ContentValues();
            cv.put("tipo_evaluador", tipoevaluador.getTipo_evaluador());
            cv.put("descripcion", tipoevaluador.getDescripcion());
            db.update("tipoevaluador", cv, "id_tipo_evaluador = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con tipoevaluador " + tipoevaluador.getId_tipo_evaluador() + " no existe";
        }
    }
    /*Codigos de Eliminacion de Datos a las diferentes Tablas*/
    public String eliminarDocente(Docente docente){
        String regAfectados="filas afectadas= ";
        int contador=0;
        contador+=db.delete("docente", "id_docente='"+docente.getId_docente()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }
    public String eliminarTipoevaluador(Tipoevaluador tipoevaluador){
        String regAfectados="filas afectadas= ";
        int contador=0;
        contador+=db.delete("tipoevaluador", "id_tipo_evaluador='"+tipoevaluador.getId_tipo_evaluador()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }
    /*Codigos de Consulta de Datos a las diferentes Tablas*/
    public Docente consultarDocente(String id_docente){
        String[] id = {id_docente};
        Cursor cursor = db.query("docente", camposDocente, "id_docente = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Docente docente = new Docente();
            docente.setId_docente(cursor.getString(0));
            docente.setNombre_docente(cursor.getString(1));
            return docente;
        }else{
            return null;
        }
    }
    public Tipoevaluador consultarTipoevaluador(String id_tipo_evaluador){
        String[] id = {id_tipo_evaluador};
        Cursor cursor = db.query("tipoevaluador", camposTipoevaluador, "id_tipo_evaluador = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Tipoevaluador tip = new Tipoevaluador();
            tip.setId_tipo_evaluador(cursor.getString(0));
            tip.setTipo_evaluador(cursor.getString(1));
            tip.setDescripcion(cursor.getString(2));
            return tip;
        }else{
            return null;
        }
    }
    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch(relacion){
            case 1:
            {
                //verificar que exista docente
                Docente doc = (Docente) dato;
                String[] id = {doc.getId_docente()};
                abrir();
                Cursor c2 = db.query("docente", null, "id_docente = ?", id, null, null, null);
                if(c2.moveToFirst()){
                    //Se encontro Docente
                    return true;
                }
                return false;
            }
            case 2:
            {
                //verificar que exista Tipo Evaluador
                Tipoevaluador tip = (Tipoevaluador) dato;
                String[] id = {tip.getId_tipo_evaluador()};
                abrir();
                Cursor c2 = db.query("tipoevaluador", null, "id_tipo_evaluador = ?", id, null, null, null);
                if(c2.moveToFirst()){
                    //Se encontro Tipo Evaluador
                    return true;
                }
                return false;
            }
            default:
                return false;
        }
    }
    public String llenarBDProyec(){
        final String[] VAid_docente = {"OO1203","OF1204","GG1109","CC1202"};
        final String[] VAnombre_docente = {"Carlos Perez","Pedro Lopez","Sara Guardado","Gabriela Recinos"};
        final String[] VBid_tipo_evaluador = {"EVA001","EVA002","EVA003","EVA004"};
        final String[] VBtipo_evaluador = {"Evaluador Principal","Apoyador","Evaluador Secundario","Juez"};
        final String[] VBdescripcion = {"Evaluador que entrega la nota segun progreso","Evaluador que apoya el evaluador pricipal","Evaluador que apoya al estudiante en el trancurso del proyecto","Evaluador encargado de calificar"};
        abrir();
        db.execSQL("DELETE FROM docente");
        db.execSQL("DELETE FROM tipoevaluador");
        Docente docente = new Docente();
        for(int i=0;i<4;i++){
            docente.setId_docente(VAid_docente[i]);
            docente.setNombre_docente(VAnombre_docente[i]);
            insertarDocente(docente);
        }
        Tipoevaluador tip = new Tipoevaluador();
        for(int i=0;i<4;i++){
            tip.setId_tipo_evaluador(VBid_tipo_evaluador[i]);
            tip.setTipo_evaluador(VBtipo_evaluador[i]);
            tip.setDescripcion(VBdescripcion[i]);
            insertarTipoevaluador(tip);
        }
        cerrar();
        return "Guardo Correctamente";
    }
}
