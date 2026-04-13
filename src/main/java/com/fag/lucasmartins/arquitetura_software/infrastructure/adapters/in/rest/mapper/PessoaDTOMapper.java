package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;

public class PessoaDTOMapper {

    private PessoaDTOMapper() {
    }

    //feat: Antonio - Mapeia um objeto PessoaDTO para um objeto PessoaBO.
    public static PessoaBO toBo(PessoaDTO dto) {
        PessoaBO bo = new PessoaBO();
        bo.setId(dto.getId());
        bo.setNomeCompleto(dto.getNomeCompleto());
        bo.setCpf(dto.getCpf());
        bo.setDataNascimento(dto.getDataNascimento());
        bo.setEmail(dto.getEmail());
        bo.setTelefone(dto.getTelefone());
        return bo;
    }

    //feat: Antonio - Mapeia um objeto PessoaBO para um objeto PessoaDTO.
    public static PessoaDTO toDto(PessoaBO bo) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(bo.getId());
        dto.setNomeCompleto(bo.getNomeCompleto());
        dto.setCpf(bo.getCpf());
        dto.setDataNascimento(bo.getDataNascimento());
        dto.setEmail(bo.getEmail());
        dto.setTelefone(bo.getTelefone());
        return dto;
    }
}
