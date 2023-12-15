package flexpass.api.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flexpass.api.demo.models.AcademiaModel;
import flexpass.api.demo.repositories.AcademiaRepository;

@Service
public class AcademiaService {

    @Autowired
    private AcademiaRepository academiaRepository;
    
    @Transactional
    public List<AcademiaModel> getAllAcademias() {
        return academiaRepository.findAll();
    }

    @Transactional
    public AcademiaModel getAcademiaById(Long gymID) {
        return academiaRepository.findById(gymID).orElse(null);
    }

    @Transactional
    public AcademiaModel createAcademia(AcademiaModel academia) {
        return academiaRepository.save(academia);
    }

    @Transactional
    public AcademiaModel updateAcademia(Long gymID, AcademiaModel updatedAcademia) {
        AcademiaModel existingAcademia = academiaRepository.findById(gymID).orElse(null);
        if (existingAcademia != null) {
            existingAcademia.setGymNome(updatedAcademia.getGymNome());
            existingAcademia.setGymEndereco(updatedAcademia.getGymEndereco());
            existingAcademia.setLimiteUsuarios(updatedAcademia.getLimiteUsuarios());
            existingAcademia.setHorarioAbertura(updatedAcademia.getHorarioAbertura());
            existingAcademia.setHorarioFechamento(updatedAcademia.getHorarioFechamento());

            return academiaRepository.save(existingAcademia);
        }
        return null; // Academia não encontrada
    }

    @Transactional
    public void deleteAcademia(Long gymID) {
        academiaRepository.deleteById(gymID);
    }
}
