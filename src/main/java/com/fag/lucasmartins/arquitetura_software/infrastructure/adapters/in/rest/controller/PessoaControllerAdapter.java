package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.controller;
import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PessoaServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper.PessoaDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//feat: Antonio - Adapter para expor a funcionalidade de Pessoa via API REST.
@RestController
@RequestMapping("/pessoas")
public class PessoaControllerAdapter {

    private final PessoaServicePort pessoaServicePort;

    public PessoaControllerAdapter(PessoaServicePort pessoaServicePort) {
        this.pessoaServicePort = pessoaServicePort;
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> cadastrarPessoa(@RequestBody PessoaDTO pessoaDTO) {

        PessoaBO pessoaBO = PessoaDTOMapper.toBo(pessoaDTO); //Converte DTO para BO.
        PessoaBO pessoaCriadaBo = pessoaServicePort.salvar(pessoaBO); // Chama a regra de negócio (O Service vai tentar salvar e validar).
        PessoaDTO pessoaCriadaDTO = PessoaDTOMapper.toDto(pessoaCriadaBo); // Converte o BO criado de volta para DTO para retornar na resposta.

        return ResponseEntity.status(201).body(pessoaCriadaDTO);
    }
}
