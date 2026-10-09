package co.edu.cineflow.salas;

import co.edu.cineflow.common.api.ApiResponse;
import co.edu.cineflow.common.api.ResponseBuilder;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/salas")
public class SalaController {
    private final SalaHandler salaHandler;

    public SalaController(SalaHandler salaHandler) {
        this.salaHandler = salaHandler;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<SalaDTO>>> findAll(@ParameterObject Pageable pageable) {
        return ResponseBuilder.ok("OK", salaHandler.findAll(pageable));
    }
}
