package co.edu.cineflow.peliculas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PeliculaHandler {

    private final PeliculaService peliculaService;

    public PeliculaHandler(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    public PeliculaDTO create(PeliculaCreateDTO in) {
        PeliculaEntity entity = toEntity(in);
        return toDTO(peliculaService.create(entity));
    }

    public PeliculaDTO findById(Integer id) {
        return toDTO(peliculaService.findById(id));
    }

    public Page<PeliculaDTO> findAll(Pageable pageable) {
        return peliculaService.findAll(pageable).map(this::toDTO);
    }

    public PeliculaDTO update(Integer id, PeliculaUpdateDTO in) {
        PeliculaEntity entity = toEntity(in);
        return toDTO(peliculaService.update(id, entity));
    }

    public void delete(Integer id) {
        peliculaService.delete(id);
    }

    private PeliculaDTO toDTO(PeliculaEntity entity) {
        PeliculaDTO dto = new PeliculaDTO();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setSinopsis(entity.getSinopsis());
        dto.setDuracionMinutos(entity.getDuracionMinutos());
        dto.setGenero(entity.getGenero());
        return dto;
    }

    private PeliculaEntity toEntity(PeliculaCreateDTO dto) {
        PeliculaEntity entity = new PeliculaEntity();
        entity.setTitulo(dto.getTitulo());
        entity.setSinopsis(dto.getSinopsis());
        entity.setDuracionMinutos(dto.getDuracionMinutos());
        entity.setGenero(dto.getGenero());
        return entity;
    }

    private PeliculaEntity toEntity(PeliculaUpdateDTO dto) {
        PeliculaEntity entity = new PeliculaEntity();
        entity.setTitulo(dto.getTitulo());
        entity.setSinopsis(dto.getSinopsis());
        entity.setDuracionMinutos(dto.getDuracionMinutos());
        entity.setGenero(dto.getGenero());
        return entity;
    }
}