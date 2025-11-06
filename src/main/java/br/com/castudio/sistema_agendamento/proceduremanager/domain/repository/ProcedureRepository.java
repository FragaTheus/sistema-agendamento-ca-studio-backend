package br.com.castudio.sistema_agendamento.proceduremanager.domain.repository;

import br.com.castudio.sistema_agendamento.proceduremanager.domain.entity.Procedure;

public interface ProcedureRepository {

    public Procedure save(Procedure procedure);

    public Procedure findById(Procedure procedure);

    public Procedure findByName(Procedure procedure);


    public void delete(Procedure procedure);

}
