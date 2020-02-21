package com.example.demo.TomaMiManoWeb.repositorios;


import com.example.demo.TomaMiManoWeb.entidades.Match;
import com.example.demo.TomaMiManoWeb.entidades.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValoracionRepositorio extends JpaRepository<Valoracion,String> {
    @Query("SELECT c FROM Voto c WHERE c.usuario.id_usu= :id_usu ORDER BY c.fecha DESC")
    public List<Valoracion> buscarValoracionesRecibidos(@Param("id_usu")String id_usu );



}
