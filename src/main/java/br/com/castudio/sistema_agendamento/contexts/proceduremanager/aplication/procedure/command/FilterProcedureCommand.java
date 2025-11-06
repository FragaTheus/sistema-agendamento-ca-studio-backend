package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.command;

import lombok.Builder;

@Builder
public record FilterProcedureCommand(
        String name,
        String category,
        Boolean isActive
) {
}
