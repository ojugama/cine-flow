package co.edu.cineflow.salas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class SalaHandler {
    private final SalaService salaService;
    private final SalaMapper salaMapper;

    public SalaHandler(SalaService salaService, SalaMapper salaMapper) {
        this.salaService = salaService;
        this.salaMapper = salaMapper;
    }

    public Page<SalaDTO> findAll(Pageable pageable) {
        return salaService.findAll(pageable).map(salaMapper::toDto);
    }
}
