package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.domainservice.procedure.command;

public record UpdateProcedureCommand(
        String name,
        String description,
        String category,
        String price,
        Integer duration
) {
}
