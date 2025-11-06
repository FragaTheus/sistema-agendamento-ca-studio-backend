package br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.repository;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity.Procedure;

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
}
