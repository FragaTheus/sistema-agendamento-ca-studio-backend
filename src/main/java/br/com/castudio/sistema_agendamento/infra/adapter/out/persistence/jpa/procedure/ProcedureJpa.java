package br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.jpa.procedure;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProcedureJpa extends JpaRepository<Procedure, Long> {

    List<Procedure> findByActiveIsTrue();

    List<Procedure> findByCategory(String category);

    Procedure findByName(String name);

    boolean exitsByName(String name);
}
