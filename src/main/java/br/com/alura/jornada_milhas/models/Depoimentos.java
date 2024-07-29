package br.com.alura.jornada_milhas.models;

import br.com.alura.jornada_milhas.dto.CadastroDTO;
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

}
