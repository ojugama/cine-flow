package co.edu.cineflow.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioUpdateDTO {
    @NotBlank(message = "El email es obligatorio.")
    @Email(message = "Formato de email inválido.")
    private String email;
    @NotBlank(message = "Los nombres son obligatorios.")
    private String nombres;
    @NotBlank(message = "Los apellidos son obligatorios.")
    private String apellidos;
}
