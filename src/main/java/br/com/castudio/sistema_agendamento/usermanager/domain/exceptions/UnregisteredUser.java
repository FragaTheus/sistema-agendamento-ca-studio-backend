package br.com.castudio.sistema_agendamento.usermanager.domain.exceptions;

public class UnregisteredUser extends RuntimeException {
    public UnregisteredUser() {
        super("Email nao encontrado nos registros.");
    }
}
