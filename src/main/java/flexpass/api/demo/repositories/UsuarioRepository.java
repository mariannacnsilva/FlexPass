package flexpass.api.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import flexpass.api.demo.models.UsuarioModel;

// automatizar as alteracoes ta tabela
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

}