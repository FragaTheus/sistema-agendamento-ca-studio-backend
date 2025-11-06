package br.com.castudio.sistema_agendamento.aplication.aplicationservices.recovery.contract;

import br.com.castudio.sistema_agendamento.aplication.aplicationservices.recovery.command.RecoveryCommand;

public interface RecoveryService {

    public void recoveryPassword(RecoveryCommand command);

}
