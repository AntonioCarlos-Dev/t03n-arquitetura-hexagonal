package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.jpa;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

// feat: Antonio - Repositório JPA para entidade Pessoa.
public interface PessoaJpaRepository extends JpaRepository<PessoaEntity, UUID> {
}
