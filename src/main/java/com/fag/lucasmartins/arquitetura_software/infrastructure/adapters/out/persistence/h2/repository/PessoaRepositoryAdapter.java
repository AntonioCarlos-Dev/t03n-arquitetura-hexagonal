package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.repository;
import com.fag.lucasmartins.arquitetura_software.application.ports.out.persistence.h2.PessoaRepositoryPort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.jpa.PessoaJpaRepository;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper.PessoaMapper;
import org.springframework.stereotype.Repository;

// feat: Antonio - Adapter para integração com o repositório JPA de Pessoa.
@Repository
public class PessoaRepositoryAdapter implements PessoaRepositoryPort {
    private final PessoaJpaRepository jpaRepository;

    public PessoaRepositoryAdapter(PessoaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PessoaBO salvar(PessoaBO pessoaBO) {
        PessoaEntity entity = PessoaMapper.toEntity(pessoaBO); // Traduz o BO para a linguagem do banco (Entity).
        PessoaEntity entitySalva = jpaRepository.save(entity); // Salva no banco H2.
        return PessoaMapper.toBO(entitySalva);
    }
}
