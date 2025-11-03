package br.com.castudio.sistema_agendamento.domain.exceptions.business;

public class UnregisteredUser extends RuntimeException {
    public UnregisteredUser() {
        super("Email nao encontrado nos registros.");
    }
}
