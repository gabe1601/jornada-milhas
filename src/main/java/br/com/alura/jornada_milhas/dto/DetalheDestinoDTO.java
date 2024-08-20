package br.com.alura.jornada_milhas.dto;

import br.com.alura.jornada_milhas.models.Destinos;

public record DetalheDestinoDTO(String foto, String nome, Double preco) {

    public DetalheDestinoDTO(Destinos destinos){
        this(destinos.getFoto(),destinos.getNome(),destinos.getPreco());
    }

}
