package co.edu.cineflow.usuarios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class UsuarioHandler {
    private final UsuarioService usuarioService;

    public UsuarioHandler(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    private UsuarioDTO toDto(UsuarioEntity usuarioEntity) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuarioEntity.getId());
        usuarioDTO.setEmail(usuarioEntity.getEmail());
        usuarioDTO.setRol(usuarioEntity.getRol());
        usuarioDTO.setNombres(usuarioEntity.getNombres());
        usuarioDTO.setApellidos(usuarioEntity.getApellidos());

        return usuarioDTO;
    }

    public UsuarioDTO create(UsuarioCreateDTO in) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setEmail(in.getEmail());
        usuarioEntity.setPassword(in.getPassword());
        usuarioEntity.setNombres(in.getNombres());
        usuarioEntity.setApellidos(in.getApellidos());

        return toDto(usuarioService.create(usuarioEntity));
    }

    public UsuarioDTO findById(Long id) {
        return toDto(usuarioService.findById(id));
    }

    public Page<UsuarioDTO> findAll(Pageable pageable) {
        return usuarioService.findAll(pageable).map(this::toDto);
    }

    public UsuarioDTO update(Long id, UsuarioUpdateDTO in) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setEmail(in.getEmail());
        usuarioEntity.setNombres(in.getNombres());
        usuarioEntity.setApellidos(in.getApellidos());

        return toDto(usuarioService.update(id, usuarioEntity));
    }

    public void delete(Long id) {
        usuarioService.delete(id);
    }

    public void updatePassword(String email, UsuarioPasswordUpdateDTO in) {
        usuarioService.updatePassword(email, in);
    }
}
