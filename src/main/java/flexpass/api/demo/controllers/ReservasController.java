package flexpass.api.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import flexpass.api.demo.models.ReservasModel;
import flexpass.api.demo.services.ReservasService;

// Controller é por onde o front vai se comunicar
@RestController
@RequestMapping ("/reserva")
@Validated
public class ReservasController {

    @Autowired
    private ReservasService reservaService;
    
    @PostMapping
    public ResponseEntity<Void> createReserva(@RequestBody @Validated ReservasModel reserva) {
        this.reservaService.createReserva(reserva);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{reservaID}").buildAndExpand(reserva.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    //metodos para receber os dados do front e encaminha-los
    @GetMapping("/{reservaID}")
    public ResponseEntity<ReservasModel> buscarReserva(@PathVariable Long reservaID) {
        ReservasModel reserva = this.reservaService.getReservaById(reservaID);
        return ResponseEntity.ok().body(reserva);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ReservasModel>> buscarTodosReservas() {
        List<ReservasModel> reservas = this.reservaService.getAllReservas();
        return ResponseEntity.ok().body(reservas);
    }

    @DeleteMapping("/{reservaID}")
    public ResponseEntity<Void> excluirReserva(@PathVariable Long reservaID) {
        this.reservaService.deleteReserva(reservaID);
        return ResponseEntity.noContent().build();
    }
    
}
