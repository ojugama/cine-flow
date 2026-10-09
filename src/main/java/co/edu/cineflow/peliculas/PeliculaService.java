package co.edu.cineflow.peliculas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeliculaService {

    PeliculaEntity create(PeliculaEntity in);

    PeliculaEntity findById(Integer id);

    Page<PeliculaEntity> findAll(Pageable pageable);

    PeliculaEntity update(Integer id, PeliculaEntity in);

    void delete(Integer id);
}