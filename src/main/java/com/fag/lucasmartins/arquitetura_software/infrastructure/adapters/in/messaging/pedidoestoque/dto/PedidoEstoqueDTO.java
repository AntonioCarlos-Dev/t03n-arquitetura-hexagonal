package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidoestoque.dto;

public class PedidoEstoqueDTO {

    private Integer sku;
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

}
