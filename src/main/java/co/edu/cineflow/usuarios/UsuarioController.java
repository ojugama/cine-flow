package co.edu.cineflow.usuarios;

import co.edu.cineflow.common.api.ApiResponse;
import co.edu.cineflow.common.api.ResponseBuilder;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    private final UsuarioHandler usuarioHandler;

    public UsuarioController(UsuarioHandler usuarioHandler) {
        this.usuarioHandler = usuarioHandler;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UsuarioDTO>> create(@Valid @RequestBody UsuarioCreateDTO in) {
        return ResponseBuilder.created("Se ha creado correctamente el usuario.", usuarioHandler.create(in));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<UsuarioDTO>> findById(@PathVariable Long id) {
        return ResponseBuilder.ok("OK", usuarioHandler.findById(id));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<UsuarioDTO>>> findAll(@ParameterObject Pageable pageable) {
        return ResponseBuilder.ok("OK", usuarioHandler.findAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioDTO>> update(@PathVariable Long id, @Valid @RequestBody UsuarioUpdateDTO in) {
        return ResponseBuilder.created("Se ha editado correctamente el usuario.", usuarioHandler.update(id, in));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        usuarioHandler.delete(id);
        return ResponseBuilder.ok("Se ha eliminado correctamente el usuario.");
    }
}
