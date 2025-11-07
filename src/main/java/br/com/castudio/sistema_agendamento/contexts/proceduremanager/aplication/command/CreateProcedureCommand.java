package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.command;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CreateProcedureCommand(
        String name,
        String description,
        String category,
        BigDecimal price,
        Integer duration
) {



}
