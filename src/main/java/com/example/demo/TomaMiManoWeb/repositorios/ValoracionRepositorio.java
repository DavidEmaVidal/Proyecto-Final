package com.example.demo.TomaMiManoWeb.repositorios;


import com.example.demo.TomaMiManoWeb.entidades.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValoracionRepositorio extends JpaRepository<Valoracion, String> {
    @Query("SELECT c FROM Valoracion c WHERE c.usuario.id_usu= :id_usu ")
    public List<Valoracion> buscarValoracionesRecibidos(@Param("id_usu") String id_usu);

    @Query("SELECT avg(puntaje) FROM Valoracion  WHERE Valoracion.usuario.id_usu= :id_usu ")
    public double promedioValoracion(@Param("id_usu") String id_usu);


}
