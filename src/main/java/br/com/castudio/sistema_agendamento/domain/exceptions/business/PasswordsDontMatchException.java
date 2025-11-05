package br.com.castudio.sistema_agendamento.domain.exceptions.business;

public class PasswordsDontMatchException extends RuntimeException {
    public PasswordsDontMatchException() {
        super("A confirmacao da senha deve ser igual a senha.");
    }
}
