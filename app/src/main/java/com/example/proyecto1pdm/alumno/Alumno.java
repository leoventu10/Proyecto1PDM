package com.example.proyecto1pdm.alumno;

public class Alumno {
    private String carnet;
    private String id_grupo;
    private String id_plan_estudio;
    private String nombres_alumno;
    private String apellidos_alumno;

    public Alumno() {
    }

    public Alumno(String carnet, String id_grupo, String id_plan_estudio, String nombres_alumno, String apellidos_alumno) {
        this.carnet = carnet;
        this.id_grupo = id_grupo;
        this.id_plan_estudio = id_plan_estudio;
        this.nombres_alumno = nombres_alumno;
        this.apellidos_alumno = apellidos_alumno;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getId_plan_estudio() {
        return id_plan_estudio;
    }

    public void setId_plan_estudio(String id_plan_estudio) {
        this.id_plan_estudio = id_plan_estudio;
    }

    public String getNombres_alumno() {
        return nombres_alumno;
    }

    public void setNombres_alumno(String nombres_alumno) {
        this.nombres_alumno = nombres_alumno;
    }

    public String getApellidos_alumno() {
        return apellidos_alumno;
    }

    public void setApellidos_alumno(String apellidos_alumno) {
        this.apellidos_alumno = apellidos_alumno;
    }
}
