package flexpass.api.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flexpass.api.demo.models.AcademiaModel;
import flexpass.api.demo.models.MapaModel;
import flexpass.api.demo.repositories.AcademiaRepository;
import flexpass.api.demo.repositories.MapaRepository;

@Service
public class MapaService {

    @Autowired
    private MapaRepository mapaRepository;
        
    @Autowired
    private AcademiaRepository academiaRepository;

    @Transactional
    public MapaModel createMapa(MapaModel mapa) {
        return mapaRepository.save(mapa);
    }

    // Método para obter um mapa com todas as academias cadastradas
    /*@Transactional
    public MapaModel getMapaComAcademias() {
        List<AcademiaModel> academias = academiaRepository.findAll();
        MapaModel mapa = new MapaModel();
        mapa.setAcademias(academias);
        return mapa;
    }

    // Método para criar um mapa com uma lista de academias
    @Transactional
    public MapaModel criarMapaComAcademias(List<AcademiaModel> academias) {
        MapaModel mapa = new MapaModel();
        mapa.setAcademias(academias);
        return mapaRepository.save(mapa);
    }*/
    
    @Transactional
    public List<AcademiaModel> getAllAcademias() {
        return academiaRepository.findAll();
    }

}
