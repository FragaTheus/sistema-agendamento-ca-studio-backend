package br.com.castudio.sistema_agendamento.usermanager.domain.exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super("Senha incorreta!");
    }
}
