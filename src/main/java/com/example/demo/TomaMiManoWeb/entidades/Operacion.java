package com.example.demo.TomaMiManoWeb.entidades;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Operacion {
	
@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid2")

private String id_Operacion;
private String titulo;
private String detalle;
private String tipo_Operacion;

public Operacion() {
	
}

public String getId_Operacion() {
	return id_Operacion;
}

public void setId_Operacion(String id_Operacion) {
	this.id_Operacion = id_Operacion;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getDetalle() {
	return detalle;
}

public void setDetalle(String detalle) {
	this.detalle = detalle;
}

public String getTipo_Operacion() {
	return tipo_Operacion;
}

public void setTipo_Operacion(String tipo_Operacion) {
	this.tipo_Operacion = tipo_Operacion;
}

	
	
	

}
