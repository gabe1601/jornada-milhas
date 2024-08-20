package br.com.alura.jornada_milhas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroDestinoDTO(

        @NotBlank
        String foto,
        @NotBlank
        String nome,
        @NotNull
        Double preco
) {
}
