package com.example.proyecto1pdm;

public class Fase {
    private String id_fase;
    private String nombre_fase;

    public Fase() {
    }

    public Fase(String id_fase, String nombre_fase) {
        this.id_fase = id_fase;
        this.nombre_fase = nombre_fase;
    }

    public String getId_fase() {
        return id_fase;
    }

    public void setId_fase(String id_fase) {
        this.id_fase = id_fase;
    }

    public String getNombre_fase() {
        return nombre_fase;
    }

    public void setNombre_fase(String nombre_fase) {
        this.nombre_fase = nombre_fase;
    }
}
