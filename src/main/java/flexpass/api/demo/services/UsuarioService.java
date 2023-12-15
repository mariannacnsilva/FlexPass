package flexpass.api.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flexpass.api.demo.models.UsuarioModel;
import flexpass.api.demo.repositories.UsuarioRepository;

//cama de negocios que armazena metodos
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Transactional
    public List<UsuarioModel> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public UsuarioModel getUsuarioById(int cpf) {
        return usuarioRepository.findById(cpf).orElse(null);
    }

    @Transactional
    public UsuarioModel createUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public UsuarioModel updateUsuario(int cpf, UsuarioModel updatedUsuario) {
        UsuarioModel existingUsuario = usuarioRepository.findById(cpf).orElse(null);
        if (existingUsuario != null) {
            // Atualizar os campos necessários
            existingUsuario.setNome(updatedUsuario.getNome());
            existingUsuario.setEmail(updatedUsuario.getEmail());
            existingUsuario.setSenha(updatedUsuario.getSenha());
            existingUsuario.setTelefone(updatedUsuario.getTelefone());

            return usuarioRepository.save(existingUsuario);
        }
        return null; // Usuário não encontrado
    }

    @Transactional
    public void deleteUsuario(int cpf) {
        usuarioRepository.deleteById(cpf);
    }
}
