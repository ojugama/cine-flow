package co.edu.cineflow.usuarios;

import co.edu.cineflow.common.exception.BusinessException;
import co.edu.cineflow.common.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UsuarioEntity create(UsuarioEntity usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new BusinessException("El email ya se encuentra registrado.");
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        usuario.setRol("CLIENTE");

        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado con ID " + id + "."));
    }

    @Override
    public Page<UsuarioEntity> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public UsuarioEntity update(Long id, UsuarioEntity usuario) {
        UsuarioEntity existingUsuario = findById(id);

        if (usuarioRepository.existsByEmailAndIdNot(usuario.getEmail(), id)) {
            throw new BusinessException("El email ya se encuentra registrado.");
        }

        existingUsuario.setEmail(usuario.getEmail());
        existingUsuario.setNombres(usuario.getNombres());
        existingUsuario.setApellidos(usuario.getApellidos());

        return usuarioRepository.save(existingUsuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        UsuarioEntity existingUsuario = findById(id);

        usuarioRepository.delete(existingUsuario);
    }
}
