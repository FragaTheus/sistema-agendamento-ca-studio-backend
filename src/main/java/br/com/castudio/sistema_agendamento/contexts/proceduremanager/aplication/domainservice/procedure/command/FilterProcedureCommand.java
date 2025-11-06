package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.domainservice.procedure.command;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record FilterProcedureCommand(
        String name,
        String category,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        Boolean isActive) {
}
