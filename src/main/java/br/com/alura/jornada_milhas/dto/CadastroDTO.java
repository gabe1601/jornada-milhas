package br.com.alura.jornada_milhas.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastroDTO(

        @NotBlank
        String nome,
        @NotBlank
        String foto,
        @NotBlank
        String comentario
) {
}
