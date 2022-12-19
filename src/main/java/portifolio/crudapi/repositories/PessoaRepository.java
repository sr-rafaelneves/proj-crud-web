package portifolio.crudapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import portifolio.crudapi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
}
