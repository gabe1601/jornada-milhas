package br.com.alura.jornada_milhas.repository;

import br.com.alura.jornada_milhas.models.Destinos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinoRepository extends JpaRepository<Destinos, Long> {
}
