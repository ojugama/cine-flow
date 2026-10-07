package co.edu.cineflow.usuarios;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String email;
    private String rol;
    private String nombres;
    private String apellidos;
}
