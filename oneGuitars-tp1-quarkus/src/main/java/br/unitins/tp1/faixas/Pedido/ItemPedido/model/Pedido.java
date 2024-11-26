package br.unitins.tp1.faixas.Pedido.ItemPedido.model;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.tp1.faixas.EnderecoEntrega.model.EnderecoEntrega;
import br.unitins.tp1.faixas.Pagamento.model.Pagamento;
import br.unitins.tp1.faixas.Usuario.model.Usuario;
import br.unitins.tp1.faixas.Usuario.service.DefaultEntity.model.DefaultEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido extends DefaultEntity {

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_pedido", nullable = false)
    private List<ItemPedido> listaItemPedido;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_endereco_entrega", nullable = false)
    private EnderecoEntrega endereco;

    @Column(name = "tempo_pagamento", nullable = false)
    private LocalDateTime tempoPagamento;

    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.REMOVE }, orphanRemoval = true)
    @JoinColumn(name = "id_pagamento")
    private Pagamento pagamento;

    @Column
    private LocalDateTime dataCompra;

    @Column
    private Double valorTotal;

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemPedido> getListaItemPedido() {
        return listaItemPedido;
    }

    public void setListaItemPedido(List<ItemPedido> listaItemPedido) {
        this.listaItemPedido = listaItemPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EnderecoEntrega getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntrega endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getTempoPagamento() {
        return tempoPagamento;
    }

    public void setTempoPagamento(LocalDateTime tempoPagamento) {
        this.tempoPagamento = tempoPagamento;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

}