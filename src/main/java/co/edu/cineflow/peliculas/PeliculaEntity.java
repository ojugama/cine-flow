package co.edu.cineflow.peliculas;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "peliculas")
public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El título es requerido.")
    @Size(max = 100, message = "El título debe tener máximo 100 caracteres.")
    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "sinopsis", columnDefinition = "TEXT")
    private String sinopsis;

    @NotNull(message = "La duración en minutos es requerida.")
    @Min(value = 1, message = "La duración debe ser mayor a 0 minutos.")
    @Column(name = "duracion_minutos", nullable = false)
    private Integer duracionMinutos;

    @Size(max = 100, message = "El género debe tener máximo 100 caracteres.")
    @Column(name = "genero", length = 100)
    private String genero;
}