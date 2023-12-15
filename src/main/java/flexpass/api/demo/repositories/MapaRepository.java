package flexpass.api.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import flexpass.api.demo.models.MapaModel;

@Repository
public interface MapaRepository extends JpaRepository<MapaModel, Long>{

    
} 