package br.unitins.tp1.faixas.Usuario.service;

import java.util.List;

import br.unitins.tp1.faixas.Usuario.dto.ClienteDTORequest;
import br.unitins.tp1.faixas.Usuario.model.Cliente;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ClienteService {

    Cliente findById(Long id);

    List<Cliente> findByNome(String nome);
    
    List<Cliente> findAll();

    Cliente create(ClienteDTORequest dto); 
    
    Cliente update(Long id, ClienteDTORequest dto);

    void delete(Long id);
}
