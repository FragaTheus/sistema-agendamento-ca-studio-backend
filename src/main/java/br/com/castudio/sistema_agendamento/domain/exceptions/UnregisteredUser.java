package br.com.castudio.sistema_agendamento.domain.exceptions;

public class UnregisteredUser extends RuntimeException {
    public UnregisteredUser() {
        super("Email nao encontrado nos registros.");
    }
}
