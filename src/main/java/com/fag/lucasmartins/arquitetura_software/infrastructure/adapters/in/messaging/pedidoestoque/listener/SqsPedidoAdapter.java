package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidoestoque.listener;

import org.springframework.stereotype.Component;
import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidoestoque.dto.PedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidoestoque.mapper.PedidoEstoqueMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;

@Component

public class SqsPedidoAdapter {

    private final PedidoServicePort pedidoServicePort;

    public SqsPedidoAdapter(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @SqsListener("${queue.order-events}")
    public void listen(PedidoDTO dto) {
        System.out.println("Mensagem recebida: " + dto.getCustomerId());

       PedidoBO pedidoBO = PedidoEstoqueMapper.toBO(dto);

       pedidoServicePort.criarPedido(pedidoBO);

        System.out.println("Mensagem consumida com sucesso.");
    };

};