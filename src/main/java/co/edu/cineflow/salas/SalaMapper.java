package co.edu.cineflow.salas;

import org.springframework.stereotype.Component;

@Component
public class SalaMapper {
    public SalaDTO toDto(SalaEntity salaEntity) {
        SalaDTO salaDTO = new SalaDTO();

        salaDTO.setId(salaEntity.getId());
        salaDTO.setIdSucursal(salaEntity.getSucursal().getId());
        salaDTO.setNombre(salaEntity.getNombre());
        salaDTO.setFormato(salaEntity.getFormato());

        return salaDTO;
    }
}
