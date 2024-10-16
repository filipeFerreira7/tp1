package br.unitins.tp1.faixas.Cidade.service;

import java.util.List;

import br.unitins.tp1.faixas.Cidade.dto.CidadeRequestDTO;
import br.unitins.tp1.faixas.Cidade.model.Cidade;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface CidadeService {

    Cidade findById(Long id);

    List<Cidade> findByNome(String nome);
    
    List<Cidade> findAll();

    Cidade create(CidadeRequestDTO dto); 
    
    Cidade update(Long id, CidadeRequestDTO dto);

    void delete(Long id);
}
