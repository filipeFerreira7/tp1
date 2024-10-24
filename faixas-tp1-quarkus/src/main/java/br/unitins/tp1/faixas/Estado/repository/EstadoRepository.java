package br.unitins.tp1.faixas.Estado.repository;

import java.util.List;

import br.unitins.tp1.faixas.Estado.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
// Tudo que tem haver com banco de dados se remete aqui
@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado>{
    public List<Estado> findByNome(String nome) {    
       return find("SELECT e FROM Estado e WHERE e.nome LIKE ?1","%"+ nome +"%").list();
    }
 
}
