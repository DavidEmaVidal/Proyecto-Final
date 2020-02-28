
package com.example.demo.TomaMiManoWeb.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Categorias {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id_Categorias;
    
    private String nombre_Categoria;
    
    @OneToOne
    private Operacion operacion;
    

    /**
     * @return the id_Categorias
     */
    public String getId_Categorias() {
        return id_Categorias;
    }

    /**
     * @param id_Categorias the id_Categorias to set
     */
    public void setId_Categorias(String id_Categorias) {
        this.id_Categorias = id_Categorias;
    }

    /**
     * @return the nombre_Categoria
     */
    public String getNombre_Categoria() {
        return nombre_Categoria;
    }

    /**
     * @param nombre_Categoria the nombre_Categoria to set
     */
    public void setNombre_Categoria(String nombre_Categoria) {
        this.nombre_Categoria = nombre_Categoria;
    }

    /**
     * @return the operacion
     */
    public Operacion getOperacion() {
        return operacion;
    }

    /**
     * @param operacion the operacion to set
     */
    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }
    
    
   
    
    
    
    
}
