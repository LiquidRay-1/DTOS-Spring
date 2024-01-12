package com.example.creandodtos.controller;

import com.example.creandodtos.model.Usuario;
import com.example.creandodtos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Map<String,Object>> save(@RequestBody Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }
    @PostMapping("/save-dto")
    public ResponseEntity<Map<String,Object>> saveDTO(@RequestBody Usuario usuario){
        return usuarioService.guardarUsuarioDTO(usuario);
    }

}
