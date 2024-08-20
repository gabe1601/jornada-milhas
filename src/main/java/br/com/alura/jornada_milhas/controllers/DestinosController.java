package br.com.alura.jornada_milhas.controllers;

import br.com.alura.jornada_milhas.dto.AtualizaDestinoDTO;
import br.com.alura.jornada_milhas.dto.CadastroDestinoDTO;
import br.com.alura.jornada_milhas.dto.DetalheDestinoDTO;
import br.com.alura.jornada_milhas.models.Destinos;
import br.com.alura.jornada_milhas.repository.DestinoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/destinos")
public class DestinosController {

    @Autowired
    private DestinoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarDestino(@RequestBody @Valid CadastroDestinoDTO dados, UriComponentsBuilder uriBuilder) {

        var destinos = new Destinos(dados);
        repository.save(destinos);

        var uri = uriBuilder.path("destinos/{id}")
                .buildAndExpand(destinos.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalheDestinoDTO(destinos));
    }

    @GetMapping
    public ResponseEntity<Page<DetalheDestinoDTO>>listarDestinos(@PageableDefault(size = 4) Pageable pageable){

        var destinoPage = repository.findAll(pageable).map(DetalheDestinoDTO::new);

        return ResponseEntity.ok(destinoPage);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizaDestino(@RequestBody @Valid AtualizaDestinoDTO dados){

        var destino = repository.getReferenceById(dados.id());
        destino.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalheDestinoDTO(destino));
    }

}
