package br.com.castudio.sistema_agendamento.contexts.usermanager.domain.exceptions;

public class WrongKeyException extends RuntimeException {
    public WrongKeyException() {
        super("Chave administrativa incorreta!");
    }
}
