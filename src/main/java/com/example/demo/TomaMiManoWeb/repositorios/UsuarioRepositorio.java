package com.example.demo.TomaMiManoWeb.repositorios;

import com.example.demo.TomaMiManoWeb.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

	@Query("SELECT c FROM Usuario c WHERE c.dni = :dni")
	public Usuario buscarPorDni(@Param("dni") String dni);

	@Query("SELECT c FROM Usuario c ORDER BY c.nombre ASC")
	public List<Usuario> buscarTodos();
	@Query("SELECT c FROM Usuario c WHERE c.mail= :mail")
	public Usuario buscarPorMail(@Param("mail")String mail );

}
