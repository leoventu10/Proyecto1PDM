package com.example.proyecto1pdm;

public class Ciclo {
    private String id_ciclo;
    private int numero_ciclo;
    private String ciclo_activo;

    public Ciclo() {
    }

    public Ciclo(String id_ciclo, int numero_ciclo, String ciclo_activo) {
        this.id_ciclo = id_ciclo;
        this.numero_ciclo = numero_ciclo;
        this.ciclo_activo = ciclo_activo;
    }

    public String getId_ciclo() {
        return id_ciclo;
    }

    public void setId_ciclo(String id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    public int getNumero_ciclo() {
        return numero_ciclo;
    }

    public void setNumero_ciclo(int numero_ciclo) {
        this.numero_ciclo = numero_ciclo;
    }

    public String getCiclo_activo() {
        return ciclo_activo;
    }

    public void setCiclo_activo(String ciclo_activo) {
        this.ciclo_activo = ciclo_activo;
    }
}
