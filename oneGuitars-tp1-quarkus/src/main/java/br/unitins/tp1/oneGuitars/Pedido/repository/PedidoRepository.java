package br.unitins.tp1.oneGuitars.Pedido.repository;


import java.time.LocalDateTime;
import java.util.List;

import br.unitins.tp1.oneGuitars.Pedido.model.Pedido;
import br.unitins.tp1.oneGuitars.Pedido.model.Status;
import br.unitins.tp1.oneGuitars.Usuario.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {

// Tudo que tem haver com bd


 public List<Pedido> findByIdUsuario(Long idUsuario) {    
       return find("SELECT p FROM Pedido p WHERE p.usuario = ?1","%"+idUsuario+"%").list();
    }

      public List<Pedido> findByUsername(String username){
        return find("SELECT p FROM Pedido p WHERE p.usuario.pessoaFisica.conta.username = ?1", username).list();
}

  public List<Pedido> findPedidosExpirados(LocalDateTime data){
    return find ("WHERE ?1 > tempoPagamento AND pagamento is NULL",data).list();
  }

  public Pedido findByUsuarioSemPagamento (Usuario usuario){
    if(usuario != null){
      return find(" SELECT p FROM Pedido p WHERE p.usuario = ?1 AND p.pagamento is NULL",usuario).firstResult();
    }
    return null;
  }

  public List<Pedido> findByStatus(Integer idStatus){
    return find("JOIN listaStatus l WHERE l.status = ?1", Status.valueOf(idStatus)).list();
}


}


