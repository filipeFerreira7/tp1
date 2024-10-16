package br.unitins.tp1.faixas.Marca.repository;

import java.util.List;
import br.unitins.tp1.faixas.Marca.model.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
// Tudo que tem haver com banco de dados se remete aqui
@ApplicationScoped
public class MarcaRepository implements PanacheRepository<Marca>{
    public List<Marca> findByNome(String nome) {    
       return find("SELECT m FROM Marca m WHERE m.nome LIKE ?1","%"+nome+"%").list();
    }
}
