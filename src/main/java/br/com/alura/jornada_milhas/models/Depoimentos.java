package br.com.alura.jornada_milhas.models;

import br.com.alura.jornada_milhas.dto.AtualizaDepoimentoDTO;
import br.com.alura.jornada_milhas.dto.CadastroDTO;
import br.com.alura.jornada_milhas.dto.DetalhesDepoimentoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of= "id")
@Entity(name="Depoimentos")
@Table(name="depoimentos")
public class Depoimentos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String foto;
    private String comentario;

    public Depoimentos(CadastroDTO dados){
        this.comentario=dados.comentario();
        this.foto=dados.foto();
        this.nome=dados.nome();
    }

    public void atualizarDados(AtualizaDepoimentoDTO dados) {
        if(dados.comentario() != null){
            this.comentario=dados.comentario();
        }
        if(dados.nome() != null){
            this.nome=dados.nome();
        }
        if(dados.foto() != null){
            this.foto=dados.foto();
        }
    }
}
