package br.unitins.tp1.faixas.Guitarra.dto;

import br.unitins.tp1.faixas.Especificacao.dto.EspecificacaoDTOResponse;
import br.unitins.tp1.faixas.Guitarra.model.Guitarra;

public record GuitarraDTOResponse(
    Long id,
    String nome,
    String numeroSerie,
    String cor,
    Double preco,
    EspecificacaoDTOResponse especificacao
) {
 public static GuitarraDTOResponse valueOf(Guitarra guitarra){
        return new GuitarraDTOResponse(guitarra.getId(), 
                                       guitarra.getNome(), 
                                       guitarra.getNumeroSerie(),
                                       guitarra.getCor(),
                                       guitarra.getPreco(),
                                       EspecificacaoDTOResponse.valueOf(guitarra.getEspecificacao())
                                      );
    }
}
