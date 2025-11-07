package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.mapper;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.command.CreateProcedureCommand;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity.Procedure;

public record ProcedureMapper() {

    public static Procedure fromCommand(CreateProcedureCommand command){
        return new Procedure(
                command.name(),
                command.description(),
                command.category(),
                (command.price()),
                command.duration(),
                true
                );
    }

}
