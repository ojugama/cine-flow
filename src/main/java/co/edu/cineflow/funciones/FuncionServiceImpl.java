package co.edu.cineflow.funciones;

import co.edu.cineflow.common.exception.BusinessException;
import co.edu.cineflow.common.exception.NotFoundException;
import co.edu.cineflow.peliculas.PeliculaEntity;
import co.edu.cineflow.peliculas.PeliculaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FuncionServiceImpl implements FuncionService {

    private final FuncionRepository funcionRepository;
    private final PeliculaService peliculaService;

    public FuncionServiceImpl(FuncionRepository funcionRepository, PeliculaService peliculaService) {
        this.funcionRepository = funcionRepository;
        this.peliculaService = peliculaService;
    }

    @Override
    @Transactional
    public FuncionEntity create(FuncionEntity in, Long idPelicula) {
        if (in.getFechaHoraFin().isBefore(in.getFechaHoraInicio())) {
            throw new BusinessException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }

        if (funcionRepository.existeCruceHorario(in.getIdSala(), in.getFechaHoraInicio(), in.getFechaHoraFin(), null)) {
            throw new BusinessException("La sala ya tiene asignada una función en ese rango de horario.");
        }

        PeliculaEntity pelicula = peliculaService.findById(idPelicula);
        in.setPelicula(pelicula);

        return funcionRepository.save(in);
    }

    @Override
    public FuncionEntity findById(Long id) {
        return funcionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Función no encontrada con ID " + id + "."));
    }

    @Override
    public Page<FuncionEntity> findAll(Pageable pageable) {
        return funcionRepository.findAllByIsActivoTrue(pageable);
    }

    @Override
    public List<FuncionEntity> findByPelicula(Long idPelicula) {
        return funcionRepository.findByPeliculaIdAndIsActivoTrue(idPelicula);
    }

    @Override
    @Transactional
    public FuncionEntity update(Long id, FuncionEntity in, Long idPelicula) {
        FuncionEntity existing = findById(id);

        if (in.getFechaHoraFin().isBefore(in.getFechaHoraInicio())) {
            throw new BusinessException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }

        if (funcionRepository.existeCruceHorario(in.getIdSala(), in.getFechaHoraInicio(), in.getFechaHoraFin(), id)) {
            throw new BusinessException("La sala ya tiene asignada una función en ese rango de horario.");
        }

        PeliculaEntity pelicula = peliculaService.findById(idPelicula);

        existing.setPelicula(pelicula);
        existing.setIdSala(in.getIdSala());
        existing.setFechaHoraInicio(in.getFechaHoraInicio());
        existing.setFechaHoraFin(in.getFechaHoraFin());

        return funcionRepository.save(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        FuncionEntity existing = findById(id);
        existing.setIsActivo(false);
        funcionRepository.save(existing);
    }
}