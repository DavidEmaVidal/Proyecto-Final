package com.example.demo.TomaMiManoWeb.controladores;

import com.example.demo.TomaMiManoWeb.errores.ErrorServicio;
import com.example.demo.TomaMiManoWeb.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value="/Usuario")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/agregarUsuario")
    public String agregarUsuario(ModelMap modelo, MultipartFile archivo, @RequestParam String dni, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String mail, @RequestParam String clave, @RequestParam String clave2) {
        try {
            usuarioServicio.registrar(archivo,dni,nombre,apellido, mail, clave , clave2);
            modelo.put("titulo", "Usuario");
            modelo.put("descripcion", "Creado de Forma Correcta!");
            return "Usuario.html";

        } catch (ErrorServicio ex) {
            modelo.put("error", ex.getMessage());
            return "Usuario.html";
        }
    }





}
