package br.com.alura.jornada_milhas.models;

import br.com.alura.jornada_milhas.dto.AtualizaDestinoDTO;
import br.com.alura.jornada_milhas.dto.CadastroDestinoDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="id")
@Entity(name = "Destinos")
@Table(name = "destinos")
public class Destinos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foto;
    private String nome;
    private Double preco;

    public Destinos (CadastroDestinoDTO dados){
        this.foto = dados.foto();
        this.nome = dados.nome();
        this.preco = dados.preco();
    }

    public void atualizarInformacoes(@Valid AtualizaDestinoDTO dados) {
        if(dados.foto() != null){
            this.foto = dados.foto();
        }
        if(dados.preco() != null){
            this.preco = dados.preco();
        }
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
    }
}
