package br.com.alura.jornada_milhas.dto;

import br.com.alura.jornada_milhas.models.Depoimentos;

public record DetalhesDepoimentoDTO(Long id, String nome, String comentario, String foto) {

    public DetalhesDepoimentoDTO(Depoimentos dados){
        this(dados.getId(), dados.getNome(),dados.getComentario(), dados.getFoto());
    }

}
