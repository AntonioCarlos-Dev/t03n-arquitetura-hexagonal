package com.fag.lucasmartins.arquitetura_software.core.domain.bo;
import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class PessoaBO {

    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public PessoaBO() {
    }

    //feat: Antonio - Comportamentos de Pessoa, regras de negócio.
    public void validarRegras() {
        validarMaioridade();
        validarCpf();
        validarTelefone();
        validarEmail();
    }

    private void validarMaioridade() {
        if (this.dataNascimento == null) {
            throw new DomainException("Erro: A data de nascimento é obrigatória.");
        }
        int idade = Period.between(this.dataNascimento, LocalDate.now()).getYears();
        if (idade < 18) {
            throw new DomainException("Erro: O cliente deve ter no mínimo 18 anos.");
        }
    }

    private void validarCpf() {
        if (this.cpf == null || this.cpf.trim().length() != 11) {
            throw new DomainException("Erro: O CPF é obrigatório e deve conter exatamente 11 caracteres.");
        }
    }

    private void validarTelefone() {
        if (this.telefone == null || this.telefone.trim().length() != 11) {
            throw new DomainException("Erro: O telefone é obrigatório e deve possuir 11 caracteres (sem parênteses ou traços).");
        }
    }

    private void validarEmail() {
        if (this.email == null || !this.email.contains("@")) {
            throw new DomainException("Erro: O e-mail é obrigatório e deve conter '@'.");
        }
    }

    //feat: Antonio - Getters e Setters de PessoaBO, acesso aos atributos.
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}