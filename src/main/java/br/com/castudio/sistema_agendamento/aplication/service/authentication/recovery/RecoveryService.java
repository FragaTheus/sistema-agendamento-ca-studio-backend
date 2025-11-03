package br.com.castudio.sistema_agendamento.aplication.service.authentication.recovery;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.recovery.RecoveryRequest;

public interface RecoveryService {

    public void recoveryPassword(RecoveryRequest request);

}
