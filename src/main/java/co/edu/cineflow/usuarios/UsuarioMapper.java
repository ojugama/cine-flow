package co.edu.cineflow.usuarios;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioDTO toDto(UsuarioEntity usuarioEntity) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuarioEntity.getId());
        usuarioDTO.setEmail(usuarioEntity.getEmail());
        usuarioDTO.setRol(usuarioEntity.getRol());
        usuarioDTO.setNombres(usuarioEntity.getNombres());
        usuarioDTO.setApellidos(usuarioEntity.getApellidos());
        usuarioDTO.setIsActivo(usuarioEntity.getIsActivo());

        return usuarioDTO;
    }

    public UsuarioEntity toEntity(UsuarioCreateDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setEmail(usuarioDTO.getEmail());
        usuarioEntity.setPassword(usuarioDTO.getPassword());
        usuarioEntity.setNombres(usuarioDTO.getNombres());
        usuarioEntity.setApellidos(usuarioDTO.getApellidos());

        return usuarioEntity;
    }

    public UsuarioEntity toEntity(UsuarioUpdateDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setEmail(usuarioDTO.getEmail());
        usuarioEntity.setNombres(usuarioDTO.getNombres());
        usuarioEntity.setApellidos(usuarioDTO.getApellidos());

        return usuarioEntity;
    }
}
