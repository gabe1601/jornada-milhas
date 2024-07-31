package br.com.alura.jornada_milhas.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizaDepoimentoDTO (

        @NotNull
        Long id,

        String nome,
        String foto,
        String comentario){
}
