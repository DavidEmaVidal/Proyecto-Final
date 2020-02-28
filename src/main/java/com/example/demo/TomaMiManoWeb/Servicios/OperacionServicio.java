
package com.example.demo.TomaMiManoWeb.Servicios;

import com.example.demo.TomaMiManoWeb.Entidades.Operacion;
import com.example.demo.TomaMiManoWeb.Errores.ErrorServicio;
import com.example.demo.TomaMiManoWeb.Repositorios.CategoriasRepositorio;
import com.example.demo.TomaMiManoWeb.Repositorios.MatchRepositorio;
import com.example.demo.TomaMiManoWeb.Repositorios.OperacionRepositorio;
import com.example.demo.TomaMiManoWeb.Repositorios.UsuarioRepositorio;
import com.example.demo.TomaMiManoWeb.enumeraciones.TipoOperacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OperacionServicio {
    
    @Autowired
    private OperacionRepositorio operacionRepositorio;
    
    @Autowired
    private MatchRepositorio matchRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private CategoriasRepositorio categoriasRepositorio;

    public  void registrarOperacion(String titulo, String detalle, TipoOperacion tipoOperacion, MultipartFile archivo) throws ErrorServicio {
        validar(titulo,detalle,tipoOperacion);

    }

    public void validar(String titulo,String detalle,TipoOperacion tipoOperacion) throws ErrorServicio {
        if(titulo == null || titulo.isEmpty()){
            throw new ErrorServicio("El titulo de la operacion no puede ser nulo");
        }
        if(detalle == null|| detalle.isEmpty()){
            throw new ErrorServicio("El detalle de la operacion no puede ser nulo");
        }
        if(tipoOperacion==null){
            throw new ErrorServicio("El tipo de operacion no puede ser nulo");
        }
    }
    
    public void comprobanteOperacion(String id_Operacion, String titulo, String id_usu2, String detalle) throws ErrorServicio {
        
        Operacion operacion = new Operacion();
      
        operacion.setTitulo(titulo);

        operacion.setDetalle(detalle);

        operacion.setUsuario(usuarioRepositorio.getOne(id_usu2));

        operacionRepositorio.save(operacion);
        
    }
    
    
}
