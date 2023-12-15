/*package flexpass.api.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import flexpass.api.demo.models.AcademiaModel;
import flexpass.api.demo.models.AvaliacaoModel;
import flexpass.api.demo.services.AcademiaService;
import flexpass.api.demo.repositories.AvaliacaoRepository;

public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    
    @Autowired
    private AcademiaService academiaService;

    //obter todas as avaliações relacionadas a uma academia específica
    /*@Transactional
    public List<AvaliacaoModel> getAllAvaliacoes(AvaliacaoModel avaliacao) {
        AcademiaModel academia = academiaService.getAcademiaById(avaliacao.getAcademia().getGymID());
        return avaliacaoRepository.getAcademiaById(academia);
    }*//*

    @Transactional
    public AvaliacaoModel getAvaliacaoById(Long id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

    @Transactional
    public AvaliacaoModel createAvaliacao(AvaliacaoModel avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    @Transactional
    public void deleteAvaliacao(Long id) {
        avaliacaoRepository.deleteById(id);
    }
}*/
