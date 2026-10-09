package co.edu.cineflow.peliculas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {
    Page<PeliculaEntity> findAllByIsActivoTrue(Pageable pageable);

    Optional<PeliculaEntity> findByIdAndIsActivoTrue(Long id);

    boolean existsByTitulo(String titulo);

    boolean existsByTituloAndIdNot(String titulo, Long id);
}