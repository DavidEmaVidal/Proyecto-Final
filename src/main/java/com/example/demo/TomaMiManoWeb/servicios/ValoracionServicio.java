package com.example.demo.TomaMiManoWeb.servicios;

import com.example.demo.TomaMiManoWeb.entidades.Usuario;
import com.example.demo.TomaMiManoWeb.entidades.Valoracion;
import com.example.demo.TomaMiManoWeb.repositorios.UsuarioRepositorio;
import com.example.demo.TomaMiManoWeb.repositorios.ValoracionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ValoracionServicio {
    @Autowired
    private ValoracionRepositorio valoracionrepositorio;
    @Autowired
    private UsuarioRepositorio usuariorepositorio;

    @Transactional
    public void valorarUsuario(String id_valoracion, String puntaje, String comentario) {

        Usuario usuario = usuariorepositorio.getOne(id_valoracion);
        //debo convertirlo a un numero ya que en html se ve como String (parsear)
        int puntajeparseado = Integer.parseInt(puntaje);

        Valoracion valoracion = new Valoracion();
        valoracion.setUsuario(usuario);
        valoracion.setPuntaje(puntajeparseado);
        comentario = comentario.toUpperCase();
        valoracion.setComentario(comentario);

        valoracionrepositorio.save(valoracion);
        promedio(id_valoracion, puntaje);

    }


    public void promedio(String id_valoracion, String puntaje) {
        Usuario usuario = usuariorepositorio.getOne(id_valoracion);
        double auxpromedio = valoracionrepositorio.promedioValoracion(id_valoracion);
        usuario.setValoracionPersonal(auxpromedio);
        usuariorepositorio.save(usuario);
    }
}
