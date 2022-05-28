package com.example.proyecto1pdm;

public class Fasesgrupo {
    private String id_fase_grupo;
    private String id_grupo;
    private String id_fase;
    private String fecha_asignacion;
    private String fecha_entrega;
    private String fecha_creacion;
    private String fecha_modificacion;

    public Fasesgrupo(){
    }

    public Fasesgrupo(String id_fase_grupo, String id_grupo, String id_fase, String fecha_asignacion,
                      String fecha_entrega, String fecha_creacion, String fecha_modificacion) {
        this.id_fase_grupo = id_fase_grupo;
        this.id_grupo = id_grupo;
        this.id_fase = id_fase;
        this.fecha_asignacion = fecha_asignacion;
        this.fecha_entrega = fecha_entrega;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getId_fase_grupo() {
        return id_fase_grupo;
    }

    public void setId_fase_grupo(String id_fase_grupo) {
        this.id_fase_grupo = id_fase_grupo;
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getId_fase() {
        return id_fase;
    }

    public void setId_fase(String id_fase) {
        this.id_fase = id_fase;
    }

    public String getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(String fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
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
