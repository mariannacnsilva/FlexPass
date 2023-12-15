package flexpass.api.demo.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import flexpass.api.demo.models.AcademiaModel;
import flexpass.api.demo.models.MapaModel;
import flexpass.api.demo.services.MapaService;

@RestController
@RequestMapping("/mapa")
@Validated
public class MapaController {

    @Autowired
    private MapaService mapaService;

    @PostMapping
    public ResponseEntity<Void> createMapa(@RequestBody @Validated MapaModel mapa) {
        this.mapaService.createMapa(mapa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(mapa.mapaId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/todos-academias")
    public ResponseEntity<List<AcademiaModel>> buscarTodasAcademias() {
        List<AcademiaModel> academias = this.mapaService.getAllAcademias();
        return ResponseEntity.ok().body(academias);
    }
}
