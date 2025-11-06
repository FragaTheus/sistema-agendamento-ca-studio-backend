package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.mapper;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.command.CreateProcedureCommand;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity.Procedure;

import java.math.BigDecimal;

public record ProcedureMapper() {

    public static Procedure fromCommand(CreateProcedureCommand command){
        return new Procedure(
                command.name(),
                command.description(),
                command.category(),
                (command.price()),
                command.duration(),
                command.isActive()
                );
    }

}
