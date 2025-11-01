package br.com.castudio.sistema_agendamento.domain.exceptions;

public class NotRegisteredAdminKey extends RuntimeException {
    public NotRegisteredAdminKey(String message) {
        super(message);
    }
}
