package br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.recovery;

import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.recovery.RecoveryRequest;

public interface RecoveryService {

    public void recoveryPassword(RecoveryRequest request);

}
