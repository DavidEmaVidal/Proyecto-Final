package com.example.demo.TomaMiManoWeb.servicios;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;


import com.example.demo.TomaMiManoWeb.entidades.Foto;
import com.example.demo.TomaMiManoWeb.entidades.Usuario;
import com.example.demo.TomaMiManoWeb.errores.ErrorServicio;
import com.example.demo.TomaMiManoWeb.repositorios.DomicilioRepositorio;
import com.example.demo.TomaMiManoWeb.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class UsuarioServicio implements UserDetailsService{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private DomicilioRepositorio domicilioRepositorio;

    @Autowired
    private FotoServicio fotoServicio;
    
    @Transactional //con esto estamos diciendo q si el metodo no larga ninguna execpcion, entonces hace un comit a la base de datos y se aplican todos los cambios. En el caso q exista una excepcion y no es atrapada se vuelve atras con la transaccion  y no se aplica nada en la base de datos
    public void registrar(MultipartFile archivo,String  dni, String nombre,String apellido,String mail, String clave , String clave2) throws ErrorServicio
    {

        validar(dni,nombre,apellido, clave , clave2);
        
        Usuario usuario = new Usuario();
        usuario.setDni(dni);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setMail(mail);
        usuario.setClave(clave);
        String encriptada = new BCryptPasswordEncoder().encode(clave);
        usuario.setClave(encriptada);

        usuario.setAlta(new Date());

        Foto foto = fotoServicio.guardar(archivo);
        usuario.setFoto(foto);
    	
        usuarioRepositorio.save(usuario);
    	
        
    }
    
    @Transactional
    public void modificar(MultipartFile archivo,String  dni, String nombre,String apellido,String mail, String clave, String clave2 , Integer credito) throws ErrorServicio
    {
    

    	
        validar(dni,nombre,apellido, clave,clave2 );
        
        Optional<Usuario> respuesta = usuarioRepositorio.findById(dni);
        
        if(respuesta.isPresent())
        {
        	Usuario usuario = respuesta.get();
        	usuario.setDni(dni);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setMail(mail);
            usuario.setClave(clave);
            usuario.setCreditos(credito);
            
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
    
    private void validar(String dni,String nombre, String apellido,String clave, String clave2) throws ErrorServicio
	{
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

        if (clave==null  || clave.isEmpty()|| clave.length()<=6){
            throw new ErrorServicio("La clave de usuario no puede ser nulo o vacio y debe tener mas de 6 digitos");
        }
        if (!clave.equals(clave2)) {
            throw new ErrorServicio("Las claves deben ser iguales");
        }
	}
    @Transactional
    public void deshabilitar(String id)throws ErrorServicio{
        Optional <Usuario> respuesta = usuarioRepositorio.findById(id);

        if (respuesta.isPresent()){
            Usuario usuario = respuesta.get();
            usuario.setBaja(new Date());

            usuarioRepositorio.save(usuario);
        }else{
            throw new ErrorServicio("El usuario no existe");
        }

    }


    @Transactional
    public void habilitar(String id)throws ErrorServicio{
        Optional <Usuario> respuesta = usuarioRepositorio.findById(id);

        if (respuesta.isPresent()){
            Usuario usuario = respuesta.get();
            usuario.setBaja(null);

            usuarioRepositorio.save(usuario);
        }else{
            throw new ErrorServicio("El usuario no existe");
        }

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
