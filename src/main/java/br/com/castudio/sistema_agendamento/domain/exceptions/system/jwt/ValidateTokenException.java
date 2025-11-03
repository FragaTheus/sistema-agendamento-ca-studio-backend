package br.com.castudio.sistema_agendamento.domain.exceptions.system.jwt;

public class ValidateTokenException extends RuntimeException {
    public ValidateTokenException() {
        super("Nao foi possivar validar credenciais de autenticacao, tente novamente.");
    }
}
