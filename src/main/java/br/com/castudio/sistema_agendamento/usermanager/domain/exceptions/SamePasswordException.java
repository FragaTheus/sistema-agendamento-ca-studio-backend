package br.com.castudio.sistema_agendamento.usermanager.domain.exceptions;

public class SamePasswordException extends RuntimeException {
    public SamePasswordException(){super("A senha nao pode ser igual a anterior");}
}
