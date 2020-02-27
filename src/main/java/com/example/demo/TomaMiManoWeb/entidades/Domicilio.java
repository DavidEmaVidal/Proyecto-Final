package com.example.demo.TomaMiManoWeb.entidades;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Domicilio {
 @Id
 @GeneratedValue(generator = "uuid")
 @GenericGenerator(name = "uuid", strategy = "uuid2")
 private String id_domicilio;
 private String calle;
 private int nro;
 @Enumerated
 private String departamento;

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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id_domicilio='" + id_domicilio + '\'' +
                ", calle='" + calle + '\'' +
                ", nro=" + nro +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
