package com.fag.lucasmartins.arquitetura_software.application.services;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class PessoaService implements PessoaServicePort {

    private final PessoaRepositoryPort pessoaRepositoryPort;

    // feat: Antonio - Injeção de Dependência através do Construtor.
    public PessoaService(PessoaRepositoryPort pessoaRepositoryPort) {
        this.pessoaRepositoryPort = pessoaRepositoryPort;
    }

    // feat: Antonio - Implementação do método salvar da interface PessoaServicePort.
    @Override
    public PessoaBO salvar(PessoaBO pessoaBO) {
        pessoaBO.validarRegras();
        // Se nenhuma DomainException foi lançada, a pessoa é válida e pode ser salva.
        return pessoaRepositoryPort.salvar(pessoaBO);
    }
}
