package flexpass.api.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import flexpass.api.demo.models.AcademiaModel;

@Repository
public interface AcademiaRepository extends JpaRepository<AcademiaModel, Long>{
    
}