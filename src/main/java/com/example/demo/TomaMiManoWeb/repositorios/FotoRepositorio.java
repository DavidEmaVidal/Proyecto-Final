package com.example.demo.TomaMiManoWeb.repositorios;

import com.example.demo.TomaMiManoWeb.entidades.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FotoRepositorio extends JpaRepository<Foto, String>{
	
}
