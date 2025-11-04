package br.com.castudio.sistema_agendamento.domain.exceptions.system;

public class InternalErrorException extends RuntimeException {
    public InternalErrorException() {
        super("Erro interno, tente novamente mais tarde!");
    }
}
