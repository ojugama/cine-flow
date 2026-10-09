package co.edu.cineflow.funciones;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class FuncionDTO {
    private Long id;
    private Long idPelicula;
    private String tituloPelicula;
    private Long idSala;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Boolean isActivo;
}