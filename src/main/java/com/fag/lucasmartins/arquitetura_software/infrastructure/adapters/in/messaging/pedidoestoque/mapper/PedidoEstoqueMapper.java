package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidoestoque.mapper;

import java.util.ArrayList;
import java.util.List;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidoestoque.dto.PedidoEstoqueDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidoestoque.dto.PedidoDTO;

public class PedidoEstoqueMapper {
    
  public static PedidoBO toBO(PedidoDTO dto) {

        PedidoBO pedidoBO = new PedidoBO();
        pedidoBO.setCep(String.valueOf(dto.getZipCode()));

        PessoaBO pessoaBO = new PessoaBO();
        pessoaBO.setId(dto.getCustomerId());
        pedidoBO.setPessoa(pessoaBO);

        List<PedidoProdutoBO> itens = new ArrayList<>();
        for (PedidoEstoqueDTO itemDto : dto.getOrderItems()) {

            PedidoProdutoBO item = new PedidoProdutoBO();
            item.setQuantidade(itemDto.getAmount());

            ProdutoBO produtoBO = new ProdutoBO();
            produtoBO.setId(itemDto.getSku());

            item.setProduto(produtoBO);

            itens.add(item);
        }

        pedidoBO.setItens(itens);

        return pedidoBO;
    }
}