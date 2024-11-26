package br.unitins.tp1.faixas.Pedido.ItemPedido.dto;

import br.unitins.tp1.faixas.Pedido.model.ItemPedido;
public record ItemPedidoDTOResponse(
    Long id,
    String codigoLoteItemPedido,
    String nome,
    Integer quantidade,
    Double preco
) {
 public static ItemPedidoDTOResponse valueOf(ItemPedido itemPedido){
        return new ItemPedidoDTOResponse(
                                    itemPedido.getId(),
                                    itemPedido.getLote().getCodigo(),
                                    itemPedido.getLote().getGuitarra().getNome(),
                                    itemPedido.getQuantidade(),
                                    itemPedido.getPreco()
                                      );
    }
}
