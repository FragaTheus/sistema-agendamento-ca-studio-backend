package br.com.castudio.sistema_agendamento.aplication.aplicationservices.login.contract;

import br.com.castudio.sistema_agendamento.aplication.aplicationservices.login.command.LoginCommand;

public interface LoginService {


    public String authenticate(LoginCommand command);

}
