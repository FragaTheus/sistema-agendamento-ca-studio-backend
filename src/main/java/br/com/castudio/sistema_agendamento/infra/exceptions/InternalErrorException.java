package br.com.castudio.sistema_agendamento.infra.exceptions;

public class InternalErrorException extends RuntimeException {
    public InternalErrorException() {
        super("Erro interno, tente novamente mais tarde!");
    }
}
