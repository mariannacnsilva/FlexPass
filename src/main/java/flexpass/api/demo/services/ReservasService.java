package flexpass.api.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flexpass.api.demo.models.ReservasModel;
import flexpass.api.demo.models.UsuarioModel;
import flexpass.api.demo.repositories.ReservasRepository;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    @Autowired 
    private UsuarioService usuarioService;

    public List<ReservasModel> getAllReservas() {
        return reservasRepository.findAll();
    }

    @Transactional
    public ReservasModel getReservaById(Long id) {
        Optional<ReservasModel> reserva = this.reservasRepository.findById(id);
        return reserva.orElse(null);
    }

    @Transactional
    public ReservasModel createReserva(ReservasModel reserva) {
        UsuarioModel usuario = this.usuarioService.getUsuarioById(reserva.getUsuario().getCpf());
        reserva.setUsuario(usuario);
        reserva = this.reservasRepository.save(reserva);
        return reserva;
    }

    @Transactional
    public void deleteReserva(Long id) {
        reservasRepository.deleteById(id);
    }
}
