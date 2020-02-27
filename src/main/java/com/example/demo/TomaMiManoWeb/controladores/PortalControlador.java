package com.example.demo.TomaMiManoWeb.controladores;



import com.example.demo.TomaMiManoWeb.entidades.Usuario;
import com.example.demo.TomaMiManoWeb.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @GetMapping("/")
    public String index() {
        return "index.html";
    }


    @GetMapping("/usuario")
    public String usuario(ModelMap modelo) {
        List<Usuario> usuario = usuarioRepositorio.buscarTodos();
        modelo.put("usuario", usuario);
        return "usuario.html";


    }
}