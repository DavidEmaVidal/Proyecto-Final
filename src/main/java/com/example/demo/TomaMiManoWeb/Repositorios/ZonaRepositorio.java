package com.example.demo.TomaMiManoWeb.Repositorios;

import com.example.demo.TomaMiManoWeb.Entidades.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepositorio extends JpaRepository<Zona,String> {
}
