package com.example.demo.TomaMiManoWeb.Servicios;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.TomaMiManoWeb.Entidades.Zona;
import com.example.demo.TomaMiManoWeb.Repositorios.ZonaRepositorio;
import com.example.demo.TomaMiManoWeb.enumeraciones.Sexo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.TomaMiManoWeb.Entidades.Foto;
import com.example.demo.TomaMiManoWeb.Entidades.Usuario;
import com.example.demo.TomaMiManoWeb.Errores.ErrorServicio;
import com.example.demo.TomaMiManoWeb.Repositorios.UsuarioRepositorio;


@Service
public class UsuarioServicio implements UserDetailsService{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ZonaRepositorio zonaRepositorio;

    @Autowired
    private FotoServicio fotoServicio;
    
    @Transactional //con esto estamos diciendo q si el metodo no larga ninguna execpcion, entonces hace un comit a la base de datos y se aplican todos los cambios. En el caso q exista una excepcion y no es atrapada se vuelve atras con la transaccion  y no se aplica nada en la base de datos
    public void registrar(MultipartFile archivo, String  dni, String nombre, String apellido, String clave, int credito, String idZona, Sexo sexo) throws ErrorServicio
    {

    	Zona zona = zonaRepositorio.getOne(idZona);

        validar(dni,nombre,apellido,clave,idZona);
        
        Usuario usuario = new Usuario();
        usuario.setDni(dni);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setClave(clave);
        usuario.setCredito(credito);
        usuario.setSexo(sexo);
        Foto foto = fotoServicio.guardar(archivo);
        usuario.setFoto(foto);
    	
        usuarioRepositorio.save(usuario);
    	
        
    }
    
    @Transactional
    public void modificar(MultipartFile archivo,String  dni, String nombre,String apellido, String clave, int credito,String idZona) throws ErrorServicio
    {
    
    	Zona zona = zonaRepositorio.getOne(idZona);
    	
        validar(dni,nombre,apellido,clave, idZona);
        
        Optional<Usuario> respuesta = (Optional<Usuario>) usuarioRepositorio.findById(dni);
        
        if(respuesta.isPresent())
        {
        	Usuario usuario = respuesta.get();
        	usuario.setDni(dni);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setClave(clave);
            usuario.setCredito(credito);
            
            String idFoto = null;
            
            if(usuario.getFoto() != null)
        {
            idFoto = usuario.getFoto().getId_foto();
        }
            
            Foto foto = fotoServicio.actualizar(idFoto, archivo);
            usuario.setFoto(foto);
            
            usuarioRepositorio.save(usuario);
    		
		}
		
		else
		{
		
			throw new ErrorServicio ("No se encontro el usuario solicitado.");
			
		}
    
    }
    
    private void validar(String dni,String nombre, String apellido,String clave,String idZona) throws ErrorServicio
	{
	    if(clave == null || clave.isEmpty())
        {
        throw new ErrorServicio("Debe ingresar una clave para el cliente !!.");
        }
        if(idZona == null || idZona.isEmpty())
        {
            throw new ErrorServicio("Debe seleccionar una zona");
        }
		if(nombre == null || nombre.isEmpty())
		{
			throw new ErrorServicio("El nombre del cliente NO puede ser nulo !!.");
		}
		if(apellido == null || apellido.isEmpty())
		{
			throw new ErrorServicio("El apellido del cliente NO puede ser nulo !!.");
		}
		if(dni == null || dni.isEmpty())
		{
			throw new ErrorServicio("El DNI del cliente NO puede ser nulo !!.");
		}
		
	}

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
