package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

// feat: Antonio - Entidade que representa uma pessoa no banco de dados H2.
@Entity
@Table(name = "tb_pessoa")
public class PessoaEntity {

    @Id
    private UUID id;
    private String nomeCompleto;

    @Column(length = 11, nullable = false)
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    // feat: Antonio - getters e setters que representam as propriedades da entidade pessoa
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