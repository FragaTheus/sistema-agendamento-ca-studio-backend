package br.com.castudio.sistema_agendamento.domain.exceptions.adminKey;

public class WrongAdminKeyException extends AdminKeyException {
    public WrongAdminKeyException() {
        super("Chave administrativa incorreta");
    }
}
