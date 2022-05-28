package com.example.proyecto1pdm;

public class Avance {
    private String id_avance;
    private String id_fase_grupo;
    private String detalle_avance;
    private String fecha_entrega;
    private String observaciones;
    private String fecha_creacion;

    public Avance() {
    }

    public Avance(String id_avance, String id_fase_grupo, String detalle_avance, String fecha_entrega,
                  String observaciones, String fecha_creacion) {
        this.id_avance = id_avance;
        this.id_fase_grupo = id_fase_grupo;
        this.detalle_avance = detalle_avance;
        this.fecha_entrega = fecha_entrega;
        this.observaciones = observaciones;
        this.fecha_creacion = fecha_creacion;
    }

    public String getId_avance() {
        return id_avance;
    }

    public void setId_avance(String id_avance) {
        this.id_avance = id_avance;
    }

    public String getId_fase_grupo() {
        return id_fase_grupo;
    }

    public void setId_fase_grupo(String id_fase_grupo) {
        this.id_fase_grupo = id_fase_grupo;
    }

    public String getDetalle_avance() {
        return detalle_avance;
    }

    public void setDetalle_avance(String detalle_avance) {
        this.detalle_avance = detalle_avance;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
