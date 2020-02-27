package com.example.demo.TomaMiManoWeb.entidades;

import com.example.demo.TomaMiManoWeb.enumeraciones.Sexo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id_usu;
    private String dni;
    private String nombre;
    private String apellido;
    @Temporal(TemporalType.DATE)
    private Date fecha_nac;
    private Integer creditos;
    private String clave;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @OneToOne
    private Foto foto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date alta;

    @Temporal(TemporalType.TIMESTAMP)
    private Date baja;
    private double valoracionPersonal;
    private String mail;

    public Usuario() {
        creditos=1;
    }

    public String getId_usu() {
        return id_usu;
    }

    public void setId_usu(String id_usu) {
        this.id_usu = id_usu;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public double getValoracionPersonal() {
        return valoracionPersonal;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    public Date getBaja() {
        return baja;
    }

    public void setBaja(Date baja) {
        this.baja = baja;
    }

    public void setValoracionPersonal(double valoracionPersonal) {
        this.valoracionPersonal = valoracionPersonal;

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usu='" + id_usu + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha_nac=" + fecha_nac +
                ", creditos=" + creditos +
                ", clave='" + clave + '\'' +
                ", sexo=" + sexo +
                ", foto=" + foto +
                ", alta=" + alta +
                ", baja=" + baja +
                ", valoracionPersonal=" + valoracionPersonal +
                ", mail='" + mail + '\'' +
                '}';
    }
}
