package br.senac.tads.dsw.webservice_rest;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DadosDto {

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public DadosDto() {

    }

    public DadosDto(Integer id, String nome, String dataNascimento,
        String email, String telefone) {
            this.id = id;
            this.nome = nome;
            this.dataNascimento = LocalDate.parse (dataNascimento);
            this.email = email;
            this.telefone = telefone;
    }

}
