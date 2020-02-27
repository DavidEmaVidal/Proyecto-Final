package com.example.demo.TomaMiManoWeb.servicios;

import com.example.demo.TomaMiManoWeb.entidades.Match;
import com.example.demo.TomaMiManoWeb.entidades.Usuario;
import com.example.demo.TomaMiManoWeb.errores.ErrorServicio;
import com.example.demo.TomaMiManoWeb.repositorios.MatchRepositorio;
import com.example.demo.TomaMiManoWeb.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class MatchServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private MatchRepositorio matchRepositorio;
    @Autowired
    private NotificacionServicio notificacionServicio;

    @Transactional
    public void match(String id_usu1, String id_usu2) throws ErrorServicio {
        Match match = new Match();
        match.setFecha_pedido(new Date());
        if (id_usu1.endsWith(id_usu2)) {
            ;
            throw new ErrorServicio("No puede votarse a si mismo");
        }
        Optional<Usuario> respuesta1 = usuarioRepositorio.findById(id_usu1);
        if (respuesta1.isPresent()) {
            Usuario usuario_receptor = respuesta1.get();
            match.setUsuario_receptor(usuario_receptor);

        } else {
            throw new ErrorServicio("No existe un usuario vinculad con ese identificador ");
        }
        Optional<Usuario> respuesta2 = usuarioRepositorio.findById(id_usu2);
        if (respuesta2.isPresent()) {
            Usuario usuario_dador = respuesta2.get();
            match.setUsuario_dador(usuario_dador);
            notificacionServicio.enviar("Tus servicios han sido requeridos", "Toma mi Mano", match.getUsuario_dador().getMail());
        } else {
            throw new ErrorServicio("No existe un usuario vinculad con ese identificador ");
        }
        matchRepositorio.save(match);
    }

    @Transactional
    public void responder(String id_usu, String id_match) throws ErrorServicio {
        Optional<Match> respuesta = matchRepositorio.findById(id_match);
        if (respuesta.isPresent()) {
            Match match = respuesta.get();
            match.setFecha_confirmacion(new Date());
            if (match.getUsuario_dador().equals(id_usu)) {
                notificacionServicio.enviar("Tu solicitud ha sido aceptada", "Toma mi Mano", match.getUsuario_receptor().getMail());
                matchRepositorio.save(match);
            } else {
                throw new ErrorServicio("no tiene permiso para realizar la operacion");
            }

        } else {
            throw new ErrorServicio("No existe el match solicitado ");
        }

    }
}