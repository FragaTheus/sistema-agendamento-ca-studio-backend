package br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.command;

import lombok.Builder;

@Builder
public record DeleteProcedureCommand(String adminKey) {

}
