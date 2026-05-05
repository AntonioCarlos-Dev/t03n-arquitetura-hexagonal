package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidoestoque.dto;
import java.util.List;

public class PedidoDTO {

private Integer zipCode;
private Integer customerId;
private List<PedidoEstoqueDTO> orderItems;
private String origin;
private String occurredAt;


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(String occurredAt) {
        this.occurredAt = occurredAt;
    }

    public List<PedidoEstoqueDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<PedidoEstoqueDTO> orderItems) {
        this.orderItems = orderItems;
    }   
}