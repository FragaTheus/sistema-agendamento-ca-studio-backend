package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.domainservice.procedure.mapper;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.domainservice.procedure.command.CreateProcedureCommand;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity.Procedure;

import java.math.BigDecimal;

public record ProcedureMapper() {

    public static Procedure fromCommand(CreateProcedureCommand command){
        return new Procedure(
                command.name(),
                command.description(),
                command.category(),
                new BigDecimal(command.price()),
                command.duration(),
                command.isActive()
                );
    }

}
