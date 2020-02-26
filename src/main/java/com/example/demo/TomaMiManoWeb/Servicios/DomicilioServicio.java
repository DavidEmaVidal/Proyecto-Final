package com.example.demo.TomaMiManoWeb.Servicios;

import com.example.demo.TomaMiManoWeb.Entidades.Domicilio;
import com.example.demo.TomaMiManoWeb.Entidades.Zona;
import com.example.demo.TomaMiManoWeb.Errores.ErrorServicio;
import com.example.demo.TomaMiManoWeb.Repositorios.DomicilioRepositorio;
import com.example.demo.TomaMiManoWeb.Repositorios.ZonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DomicilioServicio{
    @Autowired
    DomicilioRepositorio domicilioRepositorio;
    @Autowired
    ZonaRepositorio zonaRepositorio;
@Transactional
public void registrarDomicilio(String calle, int nro, String idzona) throws ErrorServicio {
    validar(idzona, calle, nro);
    Domicilio domicilio =new Domicilio();
    domicilio.setCalle(calle);
    domicilio.setNro(nro);
    domicilio.setZona(zonaRepositorio.getOne(idzona));
    domicilioRepositorio.save(domicilio);
}
@Transactional
public void modificarDomicilio(String idDom,String calle,int nro,String idzona)  throws ErrorServicio {
    validar(idzona, calle, nro);
    Optional<Domicilio> respuesta = domicilioRepositorio.findById(idDom);
    if (respuesta.isPresent()) {
        Domicilio domicilio = respuesta.get();
        domicilio.setZona(zonaRepositorio.getOne(idzona));
        domicilio.setNro(nro);
        domicilio.setCalle(calle);
        domicilioRepositorio.save(domicilio);
    }
    else
        throw new ErrorServicio("No se encontro el Domicilio Solicitado");
}
@Transactional
 public void eliminarDomicilio(String idDom)throws ErrorServicio{
     Optional<Domicilio> respuesta = domicilioRepositorio.findById(idDom);
     if(respuesta.isPresent()) {
         Domicilio domicilio = respuesta.get();
         domicilioRepositorio.delete(domicilio);
     }
     else
         throw new ErrorServicio("No se encontro el Domicilio Solicitado");
    }

public void validar(String idzona,String calle,int nro) throws ErrorServicio {
    if(idzona == null ){
        throw new ErrorServicio("No ha ingresado ninguna zona");
    }
    if(calle == null || calle.isEmpty()){
        throw new ErrorServicio("No puede ingresar un nombre de calle nulo");
    }
    if(String.valueOf(nro)==null || String.valueOf(nro).isEmpty()){
        throw new ErrorServicio("No puede ingresar un numero de calle nulo");
    }
    }
}