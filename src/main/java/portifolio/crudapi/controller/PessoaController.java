package portifolio.crudapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import portifolio.crudapi.model.Pessoa;
import portifolio.crudapi.repositories.PessoaRepository;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaRepository repository;

    @PostMapping
    public Pessoa inserir(@RequestBody Pessoa pessoa){
        Pessoa result = repository.save(pessoa);
        return result;
    }

    @GetMapping("/{id}")
    public Pessoa pesquisarId(@PathVariable Integer id){
        Pessoa result = repository.findById(id).get();
        return result;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") int id){
        repository.deleteById(id);
    }

    @RequestMapping(value = "/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") int id, @RequestBody Pessoa newPessoa)
    {
        Optional<Pessoa> oldPessoa = repository.findById(id);
        if(oldPessoa.isPresent()){
            Pessoa pessoa = oldPessoa.get();
            pessoa.setNome(newPessoa.getNome());
            repository.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Pessoa> todos(){
        List<Pessoa> result = repository.findAll();
        return result;
    }

}
