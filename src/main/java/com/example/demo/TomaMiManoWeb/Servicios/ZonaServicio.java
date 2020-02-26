package com.example.demo.TomaMiManoWeb.Servicios;

import com.example.demo.TomaMiManoWeb.Entidades.Zona;
import com.example.demo.TomaMiManoWeb.Errores.ErrorServicio;
import com.example.demo.TomaMiManoWeb.Repositorios.DomicilioRepositorio;
import com.example.demo.TomaMiManoWeb.Repositorios.ZonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ZonaServicio {
    @Autowired
    ZonaRepositorio zonaRepositorio;
    @Transactional
    public void registrarzona(String nombrelocalidad,String nombreZ) throws ErrorServicio {
        validar(nombrelocalidad,nombreZ);
        Zona zona = new Zona();
        zona.setNombre(nombreZ);
        zona.setNombreLocalidad(nombrelocalidad);
        zonaRepositorio.save(zona);
    }
    @Transactional
    public void modificarzona(String id,String nombrelocalidad,String nombreZ) throws ErrorServicio{
        validar(nombrelocalidad,nombreZ);
        Optional<Zona> respuesta = zonaRepositorio.findById(id);
    if(respuesta.isPresent()){
    Zona zona =respuesta.get();
    zona.setNombreLocalidad(nombrelocalidad);
    zona.setNombre(nombreZ);
    zonaRepositorio.save(zona);
    }
    else
        throw new ErrorServicio("No se encontro la Zona Solicitada");
    }
    public void eliminarzona(String id) throws ErrorServicio{
        Optional<Zona> respuesta = zonaRepositorio.findById(id);
        if(respuesta.isPresent()){
            zonaRepositorio.delete(respuesta.get());
        }
        else
            throw new ErrorServicio("No se encontro la Zona Solicitada");

    }

    public void validar(String nombrelocalidad,String nombreZ) throws ErrorServicio {

        if(nombrelocalidad == null || nombrelocalidad.isEmpty()) {
            throw new ErrorServicio("El nombre de la localidad no puede ser nulo");
        }
        if(nombreZ == null || nombreZ.isEmpty()){
            throw new ErrorServicio("El nombre de la Zona no puede ser nulo");
        }
    }

}
