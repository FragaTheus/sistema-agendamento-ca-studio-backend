package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.command;

import lombok.Builder;

@Builder
public record CreateProcedureCommand(
        String name,
        String description,
        String category,
        String price,
        Integer duration,
        boolean isActive
) {



}
