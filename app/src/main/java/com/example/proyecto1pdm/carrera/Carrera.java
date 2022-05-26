package com.example.proyecto1pdm.carrera;

public class Carrera {
    private String id_carrera;
    private String id_plan_estudio;
    private String nombre_carrera;

    public Carrera() {
    }

    public Carrera(String id_carrera, String id_plan_estudio, String nombre_carrera) {
        this.id_carrera = id_carrera;
        this.id_plan_estudio = id_plan_estudio;
        this.nombre_carrera = nombre_carrera;
    }

    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getId_plan_estudio() {
        return id_plan_estudio;
    }

    public void setId_plan_estudio(String id_plan_estudio) {
        this.id_plan_estudio = id_plan_estudio;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }
}
