package co.edu.cineflow.usuarios;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioCreateDTO {
    @NotBlank(message = "El email es requerido." )
    @Size(max = 50, message = "El email debe tener máximo 50 caracteres.")
    @Email(message = "El email debe tener un formato válido.")    @Email(message = "Formato de email inválido.")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria.")
    private String password;

    @NotBlank(message = "El nombre es requerido.")
    @Size(max = 50, message = "El nombre debe tener máximo 50 caracteres.")
    @Pattern(regexp = "^(?!\\s)(?!.*\\s$)[A-Za-zÁÉÍÓÚáéíóúñÑ'\\- ]+$", message = "El nombre solo puede contener letras, espacios intermedios, apóstrofes y guiones.")
    private String nombres;
    
    @NotBlank(message = "El apellido es requerido.")
    @Size(max = 50, message = "El apellido debe tener máximo 50 caracteres.")
    @Pattern(regexp = "^(?!\\s)(?!.*\\s$)[A-Za-zÁÉÍÓÚáéíóúñÑ'\\- ]+$", message = "El apellido solo puede contener letras, espacios intermedios, apóstrofes y guiones.")
    private String apellidos;
}
