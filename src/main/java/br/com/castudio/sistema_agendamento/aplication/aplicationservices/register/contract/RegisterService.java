package br.com.castudio.sistema_agendamento.aplication.aplicationservices.register.contract;

import br.com.castudio.sistema_agendamento.aplication.aplicationservices.register.command.RegisterCommand;

public interface RegisterService {

    public String registerUser(RegisterCommand command);

}
