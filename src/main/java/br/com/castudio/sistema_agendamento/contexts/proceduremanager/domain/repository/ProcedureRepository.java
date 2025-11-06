package br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.repository;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity.Procedure;
import br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.repositoryimpl.procedure.query.FilterObjectQuery;

import java.util.List;

public interface ProcedureRepository {

    public Procedure save(Procedure procedure);

    public Procedure findById(Long id);

    public List<Procedure> findAll();

    public List<Procedure> findByActiveIsTrue();

    public List<Procedure> findByCategory(String category);

    public Procedure findByName(String name);

    public void delete(Procedure procedure);

    public boolean existsByName(String name);

    List<Procedure> filterProcedures(FilterObjectQuery objectQuery);
}
