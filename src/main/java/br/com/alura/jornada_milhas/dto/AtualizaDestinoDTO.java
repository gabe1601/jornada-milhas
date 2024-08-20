package br.com.alura.jornada_milhas.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

public record AtualizaDestinoDTO(

        @NotNull
        Long id,

        String nome,
        String foto,
        Double preco

) {
}
