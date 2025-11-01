package br.com.castudio.sistema_agendamento.domain.exceptions;

public class WrongAdminKeyException extends AdminKeyException {
    public WrongAdminKeyException() {
        super("Chave administrativa incorreta");
    }
}
