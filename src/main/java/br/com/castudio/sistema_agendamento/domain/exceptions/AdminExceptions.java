package br.com.castudio.sistema_agendamento.domain.exceptions;


public abstract class AdminExceptions extends RuntimeException{

    public AdminExceptions(String message){
        super(message);
    }

}
