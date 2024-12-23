package br.unitins.tp1.oneGuitars.Especificacao.dto;

import br.unitins.tp1.oneGuitars.Especificacao.model.Especificacao;

public record EspecificacaoDTOResponse(
    Long id,
    String sku,
    Double comprimento,
    String tipoMadeira,
    String tipoCaptador,
    String tipoChave
) {
 public static EspecificacaoDTOResponse valueOf(Especificacao especificacao){
            return new EspecificacaoDTOResponse(
                        especificacao.getId(),
                         especificacao.getSku(),
                         especificacao.getComprimento(),
                         especificacao.getTipoMadeira(),
                         especificacao.getTipoCaptador(),
                         especificacao.getTipoChave()
            );
 
    }
}
