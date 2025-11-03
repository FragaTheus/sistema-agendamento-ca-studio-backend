package br.com.castudio.sistema_agendamento.domain.repository;

import br.com.castudio.sistema_agendamento.domain.entity.Key;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KeyRepository extends JpaRepository<Key, Long> {
}
