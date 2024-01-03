package flexpass.api.demo.controllers;

import java.net.URI;
import java.util.List;

import javax.persistence.Id;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import flexpass.api.demo.models.UsuarioModel;
import flexpass.api.demo.services.UsuarioService;

// Controller é por onde o front vai se comunicar
@RestController
@RequestMapping (value="/usuario", method = RequestMethod.POST)
@Validated
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping
    public ResponseEntity<Void> createUsuario(@RequestBody @Validated UsuarioModel usuario) {
        this.usuarioService.createUsuario(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{Id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    //metodos para receber os dados do front e encaminha-los
    /*@GetMapping("/{Id}")
    public ResponseEntity<UsuarioModel> buscarUsuario(@PathVariable Long Id) {
        UsuarioModel usuario = this.usuarioService.getUsuarioById(Id);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<UsuarioModel>> buscarTodosUsuarios() {
        List<UsuarioModel> usuarios = this.usuarioService.getAllUsuarios();
        return ResponseEntity.ok().body(usuarios);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<UsuarioModel> updateUsuario(@PathVariable Long Id, @RequestBody @Validated UsuarioModel usuario) {
        usuario.setId(Id);
        this.usuarioService.updateUsuario(Id, usuario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long Id) {
        this.usuarioService.deleteUsuario(Id);
        return ResponseEntity.noContent().build();
    }*/
    
}
