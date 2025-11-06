package br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.exception;

public class SamePriceException extends RuntimeException {
    public SamePriceException() {
        super("Valor nao pode ser o mesmo que o anterios!");
    }
}
