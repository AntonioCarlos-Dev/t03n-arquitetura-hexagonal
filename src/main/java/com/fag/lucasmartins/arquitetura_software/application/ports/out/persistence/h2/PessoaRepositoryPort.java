package com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;

// feat: Antonio - Porta de saída para operações de Pessoa no repositório.
public interface PessoaRepositoryPort {
    PessoaBO salvar(PessoaBO pessoaBO);
}
