package br.com.alura.jornada_milhas.repository;

import br.com.alura.jornada_milhas.models.Depoimentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepoimentoRepository extends JpaRepository<Depoimentos,Long> {
}
