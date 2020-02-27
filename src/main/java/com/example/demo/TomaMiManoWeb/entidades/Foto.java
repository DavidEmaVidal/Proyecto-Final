package com.example.demo.TomaMiManoWeb.entidades;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Foto {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id_foto;
	private String nombre;
	private String mime;
	@Lob @Basic(fetch = FetchType.LAZY) //tipo de dato grande
	private byte[] contenido;
	
	public Foto() {
	
	}

	public String getId_foto() {
		return id_foto;
	}

	public void setId_foto(String id_foto) {
		this.id_foto = id_foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public byte[] getContenido() {
		return contenido;
	}

	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}


	@Override
	public String toString() {
		return "Foto{" +
				"id_foto='" + id_foto + '\'' +
				", nombre='" + nombre + '\'' +
				", mime='" + mime + '\'' +
				", contenido=" + Arrays.toString(contenido) +
				'}';
	}
}
