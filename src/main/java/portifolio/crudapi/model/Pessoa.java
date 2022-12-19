package portifolio.crudapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private long rg;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getRg() {
        return rg;
    }
    public void setRg(long rg) {
        this.rg = rg;
    }

    public Pessoa(){

    }

    public Pessoa(int id, String nome, long rg){
        this.id = id;
        this.nome = nome;
        this.rg = rg;
    }
    

}
