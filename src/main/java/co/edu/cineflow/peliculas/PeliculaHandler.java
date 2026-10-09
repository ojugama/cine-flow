package co.edu.cineflow.peliculas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PeliculaHandler {
    private final PeliculaService peliculaService;
    private final PeliculaMapper peliculaMapper;

    public PeliculaHandler(PeliculaService peliculaService, PeliculaMapper peliculaMapper) {
        this.peliculaService = peliculaService;
        this.peliculaMapper = peliculaMapper;
    }

    public PeliculaDTO create(PeliculaCreateDTO in) {
        PeliculaEntity entity = peliculaMapper.toEntity(in);

        return peliculaMapper.toDTO(peliculaService.create(entity));
    }

    public PeliculaDTO findById(Long id) {
        return peliculaMapper.toDTO(peliculaService.findById(id));
    }

    public Page<PeliculaDTO> findAll(Pageable pageable) {
        return peliculaService.findAll(pageable).map(peliculaMapper::toDTO);
    }

    public PeliculaDTO update(Long id, PeliculaUpdateDTO in) {
        PeliculaEntity entity = peliculaMapper.toEntity(in);

        return peliculaMapper.toDTO(peliculaService.update(id, entity));
    }

    public void delete(Long id) {
        peliculaService.delete(id);
    }
}