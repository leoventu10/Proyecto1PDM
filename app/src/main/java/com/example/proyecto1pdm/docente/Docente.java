package com.example.proyecto1pdm.docente;

public class Docente {
    private String id_docente;
    private String nombre_docente;

    public Docente() {
    }

    public Docente(String id_docente, String nombre_docente) {
        this.id_docente = id_docente;
        this.nombre_docente = nombre_docente;
    }

    public String getId_docente() {
        return id_docente;
    }

    public void setId_docente(String id_docente) {
        this.id_docente = id_docente;
    }

    public String getNombre_docente() {
        return nombre_docente;
    }

    public void setNombre_docente(String nombre_docente) {
        this.nombre_docente = nombre_docente;
    }
}
