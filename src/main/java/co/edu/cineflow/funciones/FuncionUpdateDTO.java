package co.edu.cineflow.funciones;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class FuncionUpdateDTO {
    @NotNull(message = "El ID de la película es requerido.")
    private Long idPelicula;

    @NotNull(message = "El ID de la sala es requerido.")
    private Long idSala;

    @NotNull(message = "La fecha y hora de inicio es requerida.")
    @Future(message = "La fecha de inicio debe ser en el futuro.")
    private LocalDateTime fechaHoraInicio;

    @NotNull(message = "La fecha y hora de fin es requerida.")
    @Future(message = "La fecha de fin debe ser en el futuro.")
    private LocalDateTime fechaHoraFin;
}