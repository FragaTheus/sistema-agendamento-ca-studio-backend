package br.com.castudio.sistema_agendamento.domain.exceptions.system.jwt;

public class ExtractTokenException extends RuntimeException {
    public ExtractTokenException() {
        super("Nao foi possivel acessar credenciais de autenticacao, tente novamente.");
    }
}
