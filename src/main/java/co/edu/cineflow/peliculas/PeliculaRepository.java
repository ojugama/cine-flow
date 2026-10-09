package co.edu.cineflow.peliculas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Integer> {

    boolean existsByTitulo(String titulo);

    boolean existsByTituloAndIdNot(String titulo, Integer id);
}