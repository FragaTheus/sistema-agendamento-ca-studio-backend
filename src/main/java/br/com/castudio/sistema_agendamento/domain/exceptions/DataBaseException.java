package br.com.castudio.sistema_agendamento.domain.exceptions;

public class DataBaseException extends RuntimeException {
    public DataBaseException() {
        super("Ops! Nao foi possivel acessar a base de dados. Entre e contato com o Studio ou tente mais tarde.");
    }
}
