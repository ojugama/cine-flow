package co.edu.cineflow.funciones;

import org.springframework.stereotype.Component;

@Component
public class FuncionMapper {
    public FuncionEntity toEntity(FuncionCreateDTO dto) {
        FuncionEntity entity = new FuncionEntity();
        entity.setIdSala(dto.getIdSala());
        entity.setFechaHoraInicio(dto.getFechaHoraInicio());
        entity.setFechaHoraFin(dto.getFechaHoraFin());
        return entity;
    }

    public FuncionEntity toEntity(FuncionUpdateDTO dto) {
        FuncionEntity entity = new FuncionEntity();
        entity.setIdSala(dto.getIdSala());
        entity.setFechaHoraInicio(dto.getFechaHoraInicio());
        entity.setFechaHoraFin(dto.getFechaHoraFin());
        return entity;
    }

    public FuncionDTO toDTO(FuncionEntity entity) {
        FuncionDTO dto = new FuncionDTO();
        dto.setId(entity.getId());
        dto.setIdSala(entity.getIdSala());
        dto.setIsActivo(entity.getIsActivo());
        dto.setFechaHoraInicio(entity.getFechaHoraInicio());
        dto.setFechaHoraFin(entity.getFechaHoraFin());

        if (entity.getPelicula() != null) {
            dto.setIdPelicula(entity.getPelicula().getId());
            dto.setTituloPelicula(entity.getPelicula().getTitulo());
        }

        return dto;
    }
}