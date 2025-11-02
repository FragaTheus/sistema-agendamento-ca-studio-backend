package br.com.castudio.sistema_agendamento.domain.exceptions;

public class WrongCredentialsException extends RuntimeException {
    public WrongCredentialsException(){
        super("Email ou senha invalidos, confira os dados inseridos e tente novamente.");
    }
}
