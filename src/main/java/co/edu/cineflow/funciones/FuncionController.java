package co.edu.cineflow.funciones;

import co.edu.cineflow.common.api.ApiResponse;
import co.edu.cineflow.common.api.ResponseBuilder;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/funciones")
public class FuncionController {

    private final FuncionHandler funcionHandler;

    public FuncionController(FuncionHandler funcionHandler) {
        this.funcionHandler = funcionHandler;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<FuncionDTO>> create(@Valid @RequestBody FuncionCreateDTO in) {
        return ResponseBuilder.created("Se ha creado correctamente la función.", funcionHandler.create(in));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<FuncionDTO>> findById(@PathVariable Long id) {
        return ResponseBuilder.ok("OK", funcionHandler.findById(id));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<FuncionDTO>>> findAll(@ParameterObject Pageable pageable) {
        return ResponseBuilder.ok("OK", funcionHandler.findAll(pageable));
    }

    @GetMapping("/pelicula/{idPelicula}")
    public ResponseEntity<ApiResponse<List<FuncionDTO>>> findByPelicula(@PathVariable Long idPelicula) {
        return ResponseBuilder.ok("OK", funcionHandler.findByPelicula(idPelicula));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<FuncionDTO>> update(@PathVariable Long id,
                                                          @Valid @RequestBody FuncionUpdateDTO in) {
        return ResponseBuilder.ok("Se ha editado correctamente la función.", funcionHandler.update(id, in));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        funcionHandler.delete(id);
        return ResponseBuilder.ok("Se ha desactivado correctamente la función.");
    }
}