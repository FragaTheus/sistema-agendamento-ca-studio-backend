package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.domainservice.procedure.contract;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.domainservice.procedure.command.CreateProcedureCommand;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.domainservice.procedure.command.FilterProcedureCommand;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.domainservice.procedure.command.UpdateProcedureCommand;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity.Procedure;

import java.util.List;

public interface ProcedureService {

    public Procedure saveProcedure(Procedure procedure);

    public Procedure findProcedureById(Long id);

    public List<Procedure> findAllProcedures();

    public List<Procedure> findActiveProcedures();

    public List<Procedure> findProcedureByCategory(String category);

    public Procedure findProcedureByName(String name);

    public boolean existProcedureByName(String name);

    public void deleteProcedure(Procedure procedure);

    public Procedure createProcedure(CreateProcedureCommand command);

    public Procedure updateProcedure(UpdateProcedureCommand command);

    public Procedure toggleProcedureStatus(Long id);

    public List<Procedure> filterProcedures(FilterProcedureCommand command);

}
