package co.edu.cineflow.usuarios;

import co.edu.cineflow.security.JwtUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class UsuarioHandler {
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;
    private final JwtUtil jwtUtil;

    public UsuarioHandler(UsuarioService usuarioService, UsuarioMapper usuarioMapper, JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
        this.jwtUtil = jwtUtil;
    }

    public UsuarioDTO create(UsuarioCreateDTO in) {
        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(in);

        return usuarioMapper.toDto(usuarioService.create(usuarioEntity));
    }

    public UsuarioDTO findById(Long id) {
        return usuarioMapper.toDto(usuarioService.findById(id));
    }

    public Page<UsuarioDTO> findAll(Pageable pageable) {
        return usuarioService.findAll(pageable).map(usuarioMapper::toDto);
    }

    public UsuarioDTO update(Long id, UsuarioUpdateDTO in) {
        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(in);

        return usuarioMapper.toDto(usuarioService.update(id, usuarioEntity));
    }

    public void delete(Long id) {
        usuarioService.delete(id);
    }

    public UsuarioDTO findMe(String email) {
        return usuarioMapper.toDto(usuarioService.findByEmail(email));
    }

    public UsuarioDTO update(String email, UsuarioUpdateDTO in) {
        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(in);

        UsuarioDTO usuarioDTO = usuarioMapper.toDto(usuarioService.update(email, usuarioEntity));

        usuarioDTO.setToken(jwtUtil.generateToken(usuarioDTO.getEmail(), usuarioDTO.getRol()));

        return usuarioDTO;
    }

    public void delete(String email) {
        usuarioService.delete(email);
    }

    public void updatePassword(String email, UsuarioPasswordUpdateDTO in) {
        usuarioService.updatePassword(email, in);
    }
}
