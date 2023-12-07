package usuario.api.criariusuario.Services;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import usuario.api.criariusuario.Models.UsuarioSpotModel;
import usuario.api.criariusuario.Repositories.UsuarioSpotRepository;

@Service
public class UsuarioSpotService {
    final UsuarioSpotRepository usuarioSpotRepository;

    public UsuarioSpotService(UsuarioSpotRepository usuaruSpotRepository) {
        this.usuarioSpotRepository = usuaruSpotRepository;
    }

    @Transactional
    public UsuarioSpotModel save(UsuarioSpotModel usuarioSpotModel) {
        return usuarioSpotRepository.save(usuarioSpotModel);

    }

    public Optional<UsuarioSpotModel> findById(UUID id) {
            return usuarioSpotRepository.findById(id);
        }

    @Transactional
    public void delete(UsuarioSpotModel usuarioSpotModel) {
        usuarioSpotRepository.delete(usuarioSpotModel);
    }
    

}
