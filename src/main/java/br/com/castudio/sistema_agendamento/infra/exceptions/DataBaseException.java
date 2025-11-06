package br.com.castudio.sistema_agendamento.infra.exceptions;

public class DataBaseException extends RuntimeException {
    public DataBaseException() {
        super("Nao foi possivel se conectar a base de dados, tente novamente mais tarde!");
    }
}
