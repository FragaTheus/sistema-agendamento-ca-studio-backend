package br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.register.contract;

import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.register.command.RegisterCommand;

public interface RegisterService {

    public String registerUser(RegisterCommand command);

}
