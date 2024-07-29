package br.com.alura.jornada_milhas.controllers;

import br.com.alura.jornada_milhas.dto.CadastroDTO;
import br.com.alura.jornada_milhas.dto.DetalhesDepoimentoDTO;
import br.com.alura.jornada_milhas.models.Depoimentos;
import br.com.alura.jornada_milhas.repository.DepoimentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/depoimentos")
public class DepoimentoController {

    @Autowired
    private DepoimentoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarDepoimento(@RequestBody @Valid CadastroDTO dados, UriComponentsBuilder uriBuilder){

        var depoimentos = new Depoimentos(dados);
        repository.save(depoimentos);

        var uri = uriBuilder.path("depoimentos/{id}")
                .buildAndExpand(depoimentos.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesDepoimentoDTO(depoimentos));
    }

}
