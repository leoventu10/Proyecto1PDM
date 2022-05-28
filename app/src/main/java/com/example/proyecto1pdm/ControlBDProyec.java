package com.example.proyecto1pdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.proyecto1pdm.carrera.Carrera;
import com.example.proyecto1pdm.ciclo.Ciclo;
import com.example.proyecto1pdm.docente.Docente;
import com.example.proyecto1pdm.plandeestudio.Plandeestudio;
import com.example.proyecto1pdm.tipoevaluador.Tipoevaluador;

public class ControlBDProyec {
    private static final String[]camposDocente = new String [] {"id_docente","nombre_docente"};
    private static final String[]camposTipoevaluador = new String[] {"id_tipo_evaluador","tipo_evaluador","descripcion"};
    private static final String[]camposPlandeestudio = new String[] {"id_plan_estudio","anio_plan_estudio"};
    private static final String[]camposCarrera = new String[] {"id_carrera","id_plan_estudio","nombre_carrera"};
    private static final String[]camposCiclo = new String[] {"id_ciclo","numero_ciclo"};
    private static final String[]camposGrupo = new String[] {"id_grupo","id_ciclo","id_carrera","fecha_creacion","fecha_modificacion"};
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
                db.execSQL("CREATE TABLE plandeestudio(id_plan_estudio VARCHAR(6) NOT NULL PRIMARY KEY, anio_plan_estudio DATE);");
                db.execSQL("CREATE TABLE carrera(id_carrera VARCHAR(6) NOT NULL PRIMARY KEY, id_plan_estudio VARCHAR(6), nombre_carrera VARCHAR(100), CONSTRAINT fk_carrera FOREIGN KEY (id_plan_estudio) REFERENCES plandeestudio(id_plan_estudio));");
                db.execSQL("CREATE TABLE ciclo(id_ciclo VARCHAR(6) NOT NULL PRIMARY KEY, numero_ciclo INTEGER);");
                db.execSQL("CREATE TABLE grupo(id_grupo VARCHAR(6) NOT NULL PRIMARY KEY, id_ciclo VARCHAR(6), id_carrera VARCHAR(6), fecha_creacion DATE, fecha_modificacion DATE, CONSTRAINT fk_grupo_ciclo FOREIGN KEY (id_ciclo) REFERENCES ciclo(id_ciclo), CONSTRAINT fk_grupo_carrera FOREIGN KEY (id_carrera) REFERENCES carrera(id_carrera));");
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
    public String insertarPlandeestudios(Plandeestudio plandeestudio){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues plan = new ContentValues();
        plan.put("id_plan_estudio", plandeestudio.getId_plan_estudio());
        plan.put("anio_plan_estudio", plandeestudio.getAnio_plan_estudio());
        contador=db.insert("plandeestudio", null, plan);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String insertarCarrera(Carrera carrera){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        if(verificarIntegridad(carrera,4))
        {
            ContentValues carr = new ContentValues();
            carr.put("id_carrera", carrera.getId_carrera());
            carr.put("id_plan_estudio", carrera.getId_plan_estudio());
            carr.put("nombre_carrera", carrera.getNombre_carrera());
            contador=db.insert("carrera", null, carr);
        }
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        } else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String insertarCiclo(Ciclo ciclo){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues cicl = new ContentValues();
        cicl.put("id_ciclo", ciclo.getId_ciclo());
        cicl.put("numero_ciclo", ciclo.getNumero_ciclo());
        contador=db.insert("ciclo", null, cicl);
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
    public String actualizarPlandeestudios(Plandeestudio plandeestudios){
        if(verificarIntegridad(plandeestudios, 3)){
            String[] id = {plandeestudios.getId_plan_estudio()};
            ContentValues cv = new ContentValues();
            cv.put("anio_plan_estudio", plandeestudios.getAnio_plan_estudio());
            db.update("plandeestudio", cv, "id_plan_estudio = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con plan de estudio " + plandeestudios.getId_plan_estudio() + " no existe";
        }
    }
    public String actualizarCarrera(Carrera carrera){
        if(verificarIntegridad(carrera, 5)){
            String[] id = {carrera.getId_carrera(), carrera.getId_plan_estudio()};
            ContentValues cv = new ContentValues();
            cv.put("nombre_carrera", carrera.getNombre_carrera());
            db.update("carrera", cv, "id_carrera = ? AND id_plan_estudio = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro no Existe";
        }
    }
    public String actualizarCiclo(Ciclo ciclo){
        if(verificarIntegridad(ciclo, 6)){
            String[] id = {ciclo.getId_ciclo()};
            ContentValues cv = new ContentValues();
            cv.put("numero_ciclo", ciclo.getNumero_ciclo());
            db.update("ciclo", cv, "id_ciclo = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con ciclo " + ciclo.getId_ciclo() + " no existe";
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
    public String eliminarPlandeestudio(Plandeestudio plandeestudio){
        String regAfectados="filas afectadas= ";
        int contador=0;
        contador+=db.delete("plandeestudio", "id_plan_estudio='"+plandeestudio.getId_plan_estudio()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }
    public String eliminarCarrera(Carrera carrera){
        String regAfectados="filas afectadas= ";
        int contador=0;
        String datos="id_carrera='"+carrera.getId_carrera()+"'";
        datos=datos+" AND id_plan_estudio='"+carrera.getId_plan_estudio()+"'";
        contador+=db.delete("carrera", datos, null);
        regAfectados+=contador;
        return regAfectados;
    }
    public String eliminarCiclo(Ciclo ciclo){
        String regAfectados="filas afectadas= ";
        int contador=0;
        contador+=db.delete("ciclo", "id_ciclo='"+ciclo.getId_ciclo()+"'", null);
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
    public Plandeestudio consultarPlandeestudio(String id_plan_estudio){
        String[] id = {id_plan_estudio};
        Cursor cursor = db.query("plandeestudio", camposPlandeestudio, "id_plan_estudio = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Plandeestudio plan = new Plandeestudio();
            plan.setId_plan_estudio(cursor.getString(0));
            plan.setAnio_plan_estudio(cursor.getString(1));
            return plan;
        }else{
            return null;
        }
    }
    public Carrera consultarCarrera(String id_carrera, String id_plan_estudio){
        String[] id = {id_carrera, id_plan_estudio};
        Cursor cursor = db.query("carrera", camposCarrera, "id_carrera = ? AND id_plan_estudio = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Carrera carr = new Carrera();
            carr.setId_carrera(cursor.getString(0));
            carr.setId_plan_estudio(cursor.getString(1));
            carr.setNombre_carrera(cursor.getString(2));
            return carr;
        }else{
            return null;
        }
    }
    public Ciclo consultarCiclo(String id_ciclo){
        String[] id = {id_ciclo};
        Cursor cursor = db.query("ciclo", camposCiclo, "id_ciclo = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Ciclo ciclo = new Ciclo();
            ciclo.setId_ciclo(cursor.getString(0));
            ciclo.setNumero_ciclo(cursor.getInt(1));
            return ciclo;
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
            case 3:
            {
                //verificar que exista Plan de estudio
                Plandeestudio plan = (Plandeestudio) dato;
                String[] id = {plan.getId_plan_estudio()};
                abrir();
                Cursor c2 = db.query("plandeestudio", null, "id_plan_estudio = ?", id, null, null, null);
                if(c2.moveToFirst()){
                    //Se encontro Plan de estudio
                    return true;
                }
                return false;
            }
            case 4:
            {
                //verificar que al insertar carrera, exista el plan de estudio
                Carrera carr = (Carrera) dato;
                String[] id1 = {carr.getId_plan_estudio()};
                //abrir();
                Cursor cursor1 = db.query("plandeestudio", null, "id_plan_estudio = ?", id1, null, null, null);
                if(cursor1.moveToFirst()){
                    //Se encontro el plan de estudio
                    return true;
                }
                return false;
            }
            case 5:
            {
                //verificar que al modificar carrera exista id de la carrera y el id del plan de estudio
                Carrera carr = (Carrera) dato;
                String[] ids = {carr.getId_carrera(), carr.getId_plan_estudio()};
                abrir();
                Cursor c = db.query("carrera", null, "id_carrera = ? AND id_plan_estudio = ?", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 6:
            {
                //verificar que al modificar ciclo exista
                Ciclo ciclo = (Ciclo) dato;
                String[] ids = {ciclo.getId_ciclo()};
                abrir();
                Cursor c = db.query("ciclo", null, "id_ciclo = ? ", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
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
        final String[] VCid_plan_estudio = {"PL0001","PL0002","PL0003","PL0004"};
        final String[] VCanio_plan_estudios = {"2012","2023","2022","2021"};
        final String[] VDid_carrera = {"ISI198","IME199","ICI198","IIN197"};
        final String[] VDid_plan_estudio = {"PL0002","PL0002","PL0001","PL0004"};
        final String[] VDnombre_carrera = {"Ingenieria en Sistemas","Ingenieria Mecanica","Ingenieria Civil","Ingenieria industrial"};
        final String[] VEid_ciclo = {"CI2019","CI2020","CI2021","CI2022"};
        final Integer[] VEnumero_ciclo = {8,7,10,6};
        abrir();
        db.execSQL("DELETE FROM docente");
        db.execSQL("DELETE FROM tipoevaluador");
        db.execSQL("DELETE FROM plandeestudio");
        db.execSQL("DELETE FROM carrera");
        db.execSQL("DELETE FROM ciclo");
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
        Plandeestudio plan = new Plandeestudio();
        for(int i=0;i<4;i++){
            plan.setId_plan_estudio(VCid_plan_estudio[i]);
            plan.setAnio_plan_estudio(VCanio_plan_estudios[i]);
            insertarPlandeestudios(plan);
        }
        Carrera carrera = new Carrera();
        for(int i=0;i<4;i++){
            carrera.setId_carrera(VDid_carrera[i]);
            carrera.setId_plan_estudio(VDid_plan_estudio[i]);
            carrera.setNombre_carrera(VDnombre_carrera[i]);
            insertarCarrera(carrera);
        }
        Ciclo ciclo = new Ciclo();
        for(int i=0;i<4;i++){
            ciclo.setId_ciclo(VEid_ciclo[i]);
            ciclo.setNumero_ciclo(VEnumero_ciclo[i]);
            insertarCiclo(ciclo);
        }
        cerrar();
        return "Guardo Correctamente";
    }
}
