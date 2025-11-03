package br.com.castudio.sistema_agendamento.domain.exceptions.system.jwt;

public class GenerateTokenException extends RuntimeException {
    public GenerateTokenException() {
        super("Nao foi possivel gerer credenciais de autenticacao, favor tente novamente.");
    }
}
