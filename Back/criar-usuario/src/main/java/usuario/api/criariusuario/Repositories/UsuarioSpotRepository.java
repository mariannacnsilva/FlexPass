package usuario.api.criariusuario.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usuario.api.criariusuario.Models.UsuarioSpotModel;

import java.util.UUID;

@Repository
public interface UsuarioSpotRepository extends JpaRepository<UsuarioSpotModel, UUID>{

    
}
