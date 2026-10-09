package co.edu.cineflow.funciones;

import co.edu.cineflow.peliculas.PeliculaEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "funciones")
public class FuncionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pelicula", nullable = false)
    private PeliculaEntity pelicula;

    @Column(name = "id_sala", nullable = false)
    private Long idSala;

    @Column(name = "fecha_hora_inicio", nullable = false)
    private LocalDateTime fechaHoraInicio;

    @NotNull(message = "La fecha y hora de fin es requerida.")
    @Column(name = "fecha_hora_fin", nullable = false)
    private LocalDateTime fechaHoraFin;

    @Column(name = "is_activo", nullable = false)
    private Boolean isActivo = true;
}