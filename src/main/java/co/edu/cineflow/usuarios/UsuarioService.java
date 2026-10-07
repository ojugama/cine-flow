package co.edu.cineflow.usuarios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {
    UsuarioEntity create(UsuarioEntity usuario);

    UsuarioEntity findById(Long id);

    Page<UsuarioEntity> findAll(Pageable pageable);

    UsuarioEntity update(Long id, UsuarioEntity usuario);

    void delete(Long id);
}
