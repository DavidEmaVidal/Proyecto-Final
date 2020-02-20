package com.example.demo.TomaMiManoWeb.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Domicilio {
    @Id
private String id_domicilio;
 private String calle;
 private int nro;

    public Domicilio() {
    }

    public String getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(String id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }
}
