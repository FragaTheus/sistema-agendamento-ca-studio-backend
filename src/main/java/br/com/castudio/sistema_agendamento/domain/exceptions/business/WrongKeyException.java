package br.com.castudio.sistema_agendamento.domain.exceptions.business;

public class WrongKeyException extends RuntimeException {
    public WrongKeyException() {
        super("Chave administrativa incorreta!");
    }
}
