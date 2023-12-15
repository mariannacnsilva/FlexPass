package flexpass.api.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import flexpass.api.demo.models.AcademiaModel;
import flexpass.api.demo.models.UsuarioModel;
import flexpass.api.demo.services.AcademiaService;

@RestController
@RequestMapping("/academia")
@Validated
public class AcademiaController {

    @Autowired
    private AcademiaService academiaService;

    @PostMapping
    public ResponseEntity<Void> createAcademia(@RequestBody @Validated AcademiaModel academia) {
        this.academiaService.createAcademia(academia);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(academia.getGymID()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademiaModel> buscarAcademia(@PathVariable Long id) {
        AcademiaModel academia = this.academiaService.getAcademiaById(id);
        return ResponseEntity.ok().body(academia);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<AcademiaModel>> buscarTodasAcademias() {
        List<AcademiaModel> academias = this.academiaService.getAllAcademias();
        return ResponseEntity.ok().body(academias);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademiaModel> updateAcademia(@PathVariable Long id, @RequestBody @Validated AcademiaModel academia) {
        academia.setGymID(id);
        this.academiaService.updateAcademia(id, academia);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAcademia(@PathVariable Long id) {
        this.academiaService.deleteAcademia(id);
        return ResponseEntity.noContent().build();
    }

}
