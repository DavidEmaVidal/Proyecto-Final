
package com.example.demo.TomaMiManoWeb.Repositorios;


import com.example.demo.TomaMiManoWeb.Entidades.Operacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OperacionRepositorio extends JpaRepository<Operacion, String> {
    
    @Query("SELECT c FROM Operacion c WHERE c.id_Operacion = :id_Operacion ORDER BY c.fecha DESC")
    public List<Operacion> buscarOperacion(String id_Operacion);
    
    
}
