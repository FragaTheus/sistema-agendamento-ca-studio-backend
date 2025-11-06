package br.com.castudio.sistema_agendamento.usermanager.domain.exceptions;

public class SameNameException extends RuntimeException {
    public SameNameException(){super("O nome precisa ser diferente do ultimo.");}
}
