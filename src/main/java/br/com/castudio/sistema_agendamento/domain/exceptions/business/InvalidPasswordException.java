package br.com.castudio.sistema_agendamento.domain.exceptions.business;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super("Senha incorreta!");
    }
}
