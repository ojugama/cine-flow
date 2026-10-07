package co.edu.cineflow.usuarios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {
    UsuarioEntity create(UsuarioEntity in);

    UsuarioEntity findById(Long id);

    Page<UsuarioEntity> findAll(Pageable pageable);

    UsuarioEntity update(Long id, UsuarioEntity in);

    void delete(Long id);

    UsuarioEntity findByEmail(String email);

    UsuarioEntity update(String email, UsuarioEntity in);

    void updatePassword(String email, UsuarioPasswordUpdateDTO in);
}
