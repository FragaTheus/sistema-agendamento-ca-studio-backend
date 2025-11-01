package br.com.castudio.sistema_agendamento.domain.exceptions.admin;

public class EmailAlreadyExistException extends AdminExceptions{

    public EmailAlreadyExistException(String email){
        super("O email "+email+" já está cadastrado.");
    }

}
