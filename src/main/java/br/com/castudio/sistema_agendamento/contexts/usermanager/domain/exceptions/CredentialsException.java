package br.com.castudio.sistema_agendamento.contexts.usermanager.domain.exceptions;

public class CredentialsException extends RuntimeException {
    public CredentialsException() {
        super("Email ou senha invalidos.");
    }
}
