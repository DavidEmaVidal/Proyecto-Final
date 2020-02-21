package com.example.demo.TomaMiManoWeb.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Zona {
    @Id
    String id_zona;
    String nombreLocalidad;
    String nombre;

    public Zona() {
    }

    public String getId_zona() {
        return id_zona;
    }

    public void setId_zona(String id_zona) {
        this.id_zona = id_zona;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
