package com.cadastro.cadastro.DTO;

import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class UsuarioResponse {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

}
