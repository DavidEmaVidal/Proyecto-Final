package com.example.demo.TomaMiManoWeb.Entidades;


import com.example.demo.TomaMiManoWeb.Entidades.Operacion;
import com.example.demo.TomaMiManoWeb.Entidades.Usuario;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Match {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id_match;

    @ManyToOne
    private Usuario usuario_receptor;
    @ManyToOne
    private Usuario usuario_dador;
    @ManyToOne
    private Operacion operacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_pedido;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_confirmacion;

    public Match() {
    }

    public String getId_match() {
        return id_match;
    }

    public void setId_match(String id_match) {
        this.id_match = id_match;
    }

    public Usuario getUsuario_receptor() {
        return usuario_receptor;
    }

    public void setUsuario_receptor(Usuario usuario_receptor) {
        this.usuario_receptor = usuario_receptor;
    }

    public Usuario getUsuario_dador() {
        return usuario_dador;
    }


    public void setUsuario_dador(Usuario usuario_dador) {
        this.usuario_dador = usuario_dador;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }
    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Date getFecha_confirmacion() {
        return fecha_confirmacion;
    }

    public void setFecha_confirmacion(Date fecha_confirmacion) {
        this.fecha_confirmacion = fecha_confirmacion;
    }


}