package com.example.creandodtos.converters;

import com.example.creandodtos.dto.UsuarioGuardadoDTO;
import com.example.creandodtos.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {
    public UsuarioGuardadoDTO convertEntityDTO(Usuario usuario){
        UsuarioGuardadoDTO usuarioGuardadoDTO = new UsuarioGuardadoDTO();
        usuarioGuardadoDTO.setUsername(usuario.getUsername());
        usuarioGuardadoDTO.setEmail(usuario.getEmail());
        usuarioGuardadoDTO.setDomicilio(usuario.getDomicilio());

        if (usuario.getGenero() == true) usuarioGuardadoDTO.setGenero("Femenino");
        else usuarioGuardadoDTO.setGenero("Masculino");

        return usuarioGuardadoDTO;
    }
}
