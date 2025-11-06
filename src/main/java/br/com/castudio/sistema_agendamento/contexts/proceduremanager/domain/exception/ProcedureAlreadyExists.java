package br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.exception;

public class ProcedureAlreadyExists extends RuntimeException {
    public ProcedureAlreadyExists() {
        super("Procedimento ja cadastrado no sistema!");
    }
}
