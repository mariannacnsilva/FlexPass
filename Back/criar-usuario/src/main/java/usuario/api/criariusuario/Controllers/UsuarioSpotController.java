package usuario.api.criariusuario.Controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import usuario.api.criariusuario.Models.UsuarioSpotModel;
import usuario.api.criariusuario.Services.UsuarioSpotService;
import usuario.api.criariusuario.dtos.UsuarioSpotDto;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

import javax.validation.*;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
//nome de requisicao
@RequestMapping("/usuario-spot")
public class UsuarioSpotController {

    final UsuarioSpotService usuarioSpotService;

    public UsuarioSpotController (UsuarioSpotService usuarioSpotService){
        this.usuarioSpotService=usuarioSpotService;
    }

    //metodo post para criar usuario:
    @PostMapping
    public ResponseEntity<Object> saveUsuarioSpot(@RequestBody @Valid UsuarioSpotDto usuarioSpotDto) {
        var usuarioSpotModel = new UsuarioSpotModel();
        BeanUtils.copyProperties(usuarioSpotDto, usuarioSpotModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSpotService.save(usuarioSpotModel));

    }

    //metodo get para retornar informações de um unico usuario (perfil):
    @GetMapping("/{cpf}") // "/spot-model/{cpf}"
        public ResponseEntity<Object> getOneUsuarioSpot(@PathVariable(value = "cpf") UUID cpf){
            Optional<UsuarioSpotModel> usuarioSpotModelOptional = usuarioSpotService.findById(cpf);
            return ResponseEntity.status(HttpStatus.OK).body(usuarioSpotModelOptional.get());
        }

    // metodo put para editar dados do usuario:
    @PutMapping("/{cpf}")
        public ResponseEntity<Object> updateUsuarioSpot(@PathVariable(value = "cpf") UUID cpf,
                                                        @RequestBody @Valid UsuarioSpotDto usuarioSpotDto){
            Optional<UsuarioSpotModel> usuarioSpotModelOptional = usuarioSpotService.findById(cpf);
            var usuarioSpotModel = new UsuarioSpotModel();
            BeanUtils.copyProperties(usuarioSpotDto, usuarioSpotModel);
            usuarioSpotModel.setCPF(usuarioSpotModelOptional.get().getCPF());
            return ResponseEntity.status(HttpStatus.OK).body(usuarioSpotService.save(usuarioSpotModel));
        }

    //metodo delete para excluir um usuario:
    @DeleteMapping("/{cpf}")
        public ResponseEntity<Object> deleteUsuarioSpot(@PathVariable(value = "cpf") UUID cpf){
            Optional<UsuarioSpotModel> usuarioSpotModelOptional = usuarioSpotService.findById(cpf);
            usuarioSpotService.delete(usuarioSpotModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
        }
        
}
