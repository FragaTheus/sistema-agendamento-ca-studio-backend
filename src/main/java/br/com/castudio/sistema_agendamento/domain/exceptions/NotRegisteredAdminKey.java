package br.com.castudio.sistema_agendamento.domain.exceptions;

public class NotRegisteredAdminKey extends AdminKeyException {
    public NotRegisteredAdminKey() {
        super("Chave administrativa nao esta cadastrada no sistema. Favor informar Studio!");
    }
}
