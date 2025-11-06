package br.com.castudio.sistema_agendamento.domain.exceptions;

public class EmailRegisteredException extends RuntimeException {
    public EmailRegisteredException() {
        super("Ja existe um cadastro com esse email!");
    }
}
