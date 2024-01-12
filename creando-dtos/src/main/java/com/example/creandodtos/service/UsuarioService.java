package com.example.creandodtos.service;

import com.example.creandodtos.converters.UsuarioConverter;
import com.example.creandodtos.dto.UsuarioGuardadoDTO;
import com.example.creandodtos.model.Usuario;
import com.example.creandodtos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioConverter usuarioConverter;

    public ResponseEntity<Map<String, Object>> guardarUsuario(Usuario usuario) {
        Map<String, Object> mapa = new HashMap<>();
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        if(usuarioGuardado.getId() != null){
            mapa.put("success", usuarioGuardado);
            return new ResponseEntity<Map<String, Object>>(mapa, HttpStatus.CREATED);
        } else {
            mapa.put("error", 701);
            return new ResponseEntity<Map<String, Object>>(mapa, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Map<String, Object>> guardarUsuarioDTO(Usuario usuario){
        Map<String, Object> mapa = new HashMap<>();
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        UsuarioGuardadoDTO usuarioGuardadoDTO = usuarioConverter.convertEntityDTO(usuarioGuardado);

        if (usuarioGuardado.getId() != null) {
            mapa.put("success", usuarioGuardadoDTO);
            return new ResponseEntity<>(mapa, HttpStatus.CREATED);
        } else {
            mapa.put("error", 701);
            return new ResponseEntity<Map<String, Object>>(mapa, HttpStatus.BAD_REQUEST);
        }
    }
}
