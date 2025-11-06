package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.command;

public record UpdateProcedureCommand(
        String name,
        String description,
        String category,
        String price,
        Integer duration
) {
}
