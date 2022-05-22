package com.example.proyecto1pdm.plandeestudio;

public class Plandeestudio {
    private String id_plan_estudio;
    private String anio_plan_estudio;

    public Plandeestudio() {
    }

    public Plandeestudio(String id_plan_estudio, String anio_plan_estudio) {
        this.id_plan_estudio = id_plan_estudio;
        this.anio_plan_estudio = anio_plan_estudio;
    }

    public String getId_plan_estudio() {
        return id_plan_estudio;
    }

    public void setId_plan_estudio(String id_plan_estudio) {
        this.id_plan_estudio = id_plan_estudio;
    }

    public String getAnio_plan_estudio() {
        return anio_plan_estudio;
    }

    public void setAnio_plan_estudio(String anio_plan_estudio) {
        this.anio_plan_estudio = anio_plan_estudio;
    }
}
