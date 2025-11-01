package br.com.castudio.sistema_agendamento.domain.exceptions;

public class DataBaseException extends RuntimeException {
    public DataBaseException(String message) {
        super(message);
    }
}
