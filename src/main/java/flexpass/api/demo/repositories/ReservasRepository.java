package flexpass.api.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import flexpass.api.demo.models.ReservasModel;

@Repository
public interface ReservasRepository extends JpaRepository<ReservasModel, Long> {
    
}