package co.edu.cineflow.usuarios;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioPasswordUpdateDTO {
    @NotBlank(message = "La contraseña actual es obligatoria.")
    private String currentPassword;
    @NotBlank(message = "La contraseña nueva es obligatoria.")
    private String newPassword;
}
