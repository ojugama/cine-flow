package co.edu.cineflow.usuarios;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El email es requerido." )
    @Size(max = 50, message = "El email debe tener máximo 50 caracteres.")
    @Email(message = "El email debe tener un formato válido.")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "contraseña es requerida." )
    @Column(name = "password_hash")
    private String password;

    @Column(name = "rol")
    private String rol;
    
    @NotBlank(message = "El nombre es requerido.")
    @Size(max = 50, message = "El nombre debe tener máximo 50 caracteres.")
    @Pattern(regexp = "^(?!\\s)(?!.*\\s$)[A-Za-zÁÉÍÓÚáéíóúñÑ'\\- ]+$", message = "El nombre solo puede contener letras, espacios intermedios, apóstrofes y guiones.")
    @Column(name = "nombres")
    private String nombres;

    @NotBlank(message = "El apellido es requerido.")
    @Size(max = 50, message = "El apellido debe tener máximo 50 caracteres.")
    @Pattern(regexp = "^(?!\\s)(?!.*\\s$)[A-Za-zÁÉÍÓÚáéíóúñÑ'\\- ]+$", message = "El apellido solo puede contener letras, espacios intermedios, apóstrofes y guiones.")
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "is_activo")
    private Boolean isActivo = true;
}
