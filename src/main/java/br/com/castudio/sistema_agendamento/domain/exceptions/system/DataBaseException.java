package br.com.castudio.sistema_agendamento.domain.exceptions.system;

public class DataBaseException extends RuntimeException {
    public DataBaseException() {
        super("Nao foi possivel se conectar a base de dados, tente novamente mais tarde!");
    }
}
