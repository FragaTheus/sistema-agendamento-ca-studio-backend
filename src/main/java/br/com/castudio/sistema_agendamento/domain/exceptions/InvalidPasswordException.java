package br.com.castudio.sistema_agendamento.domain.exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super("Senha incorreta!");
    }
}
