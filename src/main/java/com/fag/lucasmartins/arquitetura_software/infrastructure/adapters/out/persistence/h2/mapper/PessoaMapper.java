package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;
import java.util.UUID;

public class PessoaMapper {

    private PessoaMapper() {
    }

    // feat: Antonio - Converte um objeto de negócio (BO) em uma entidade (Entity).
    public static PessoaEntity toEntity(PessoaBO bo) {
        PessoaEntity entity = new PessoaEntity();
        // Se o BO não tiver ID, vai ser gerado um novo UUID
        entity.setId(bo.getId() != null ? bo.getId() : UUID.randomUUID());
        entity.setNomeCompleto(bo.getNomeCompleto());
        entity.setCpf(bo.getCpf());
        entity.setDataNascimento(bo.getDataNascimento());
        entity.setEmail(bo.getEmail());
        entity.setTelefone(bo.getTelefone());

        return entity;
    }

    public static PessoaBO toBO(PessoaEntity entity) {
        PessoaBO bo = new PessoaBO();
        bo.setId(entity.getId());
        bo.setNomeCompleto(entity.getNomeCompleto());
        bo.setCpf(entity.getCpf());
        bo.setDataNascimento(entity.getDataNascimento());
        bo.setEmail(entity.getEmail());
        bo.setTelefone(entity.getTelefone());

        return bo;
    }
}
