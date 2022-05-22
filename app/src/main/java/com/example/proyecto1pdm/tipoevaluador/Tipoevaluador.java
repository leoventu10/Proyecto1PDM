package com.example.proyecto1pdm.tipoevaluador;

public class Tipoevaluador {
    private String id_tipo_evaluador;
    private String tipo_evaluador;
    private String descripcion;

    public Tipoevaluador() {
    }

    public Tipoevaluador(String id_tipo_evaluador, String tipo_evaluador, String descripcion) {
        this.id_tipo_evaluador = id_tipo_evaluador;
        this.tipo_evaluador = tipo_evaluador;
        this.descripcion = descripcion;
    }

    public String getId_tipo_evaluador() {
        return id_tipo_evaluador;
    }

    public void setId_tipo_evaluador(String id_tipo_evaluador) {
        this.id_tipo_evaluador = id_tipo_evaluador;
    }

    public String getTipo_evaluador() {
        return tipo_evaluador;
    }

    public void setTipo_evaluador(String tipo_evaluador) {
        this.tipo_evaluador = tipo_evaluador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
