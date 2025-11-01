package br.com.castudio.sistema_agendamento.domain.exceptions;

public class PasswordDontMathcException extends AdminExceptions {

    public PasswordDontMathcException(){
        super("A senha e a confirmação de senha não conferem.");
    }

}
