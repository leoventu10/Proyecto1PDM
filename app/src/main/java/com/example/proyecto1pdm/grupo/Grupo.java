package com.example.proyecto1pdm;

import java.util.Date;

public class Grupo {
    private String id_grupo;
    private String id_ciclo;
    private String id_carrera;
    private String fecha_creacion;
    private String fecha_modificacion;

    public Grupo() {
    }

    public Grupo(String id_grupo, String id_ciclo, String id_carrera, String fecha_creacion, String fecha_modificacion) {
        this.id_grupo = id_grupo;
        this.id_ciclo = id_ciclo;
        this.id_carrera = id_carrera;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getId_ciclo() {
        return id_ciclo;
    }

    public void setId_ciclo(String id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
}
