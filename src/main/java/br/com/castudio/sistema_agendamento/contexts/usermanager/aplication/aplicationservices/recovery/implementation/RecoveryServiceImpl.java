package br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.recovery.implementation;

import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.recovery.command.RecoveryCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.recovery.contract.RecoveryService;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.domainservice.user.contract.UserService;
import br.com.castudio.sistema_agendamento.contexts.usermanager.domain.entity.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecoveryServiceImpl implements RecoveryService {

    private final UserService userService;

    @Override
    public void recoveryPassword(RecoveryCommand command) {

        User user = userService.findUserByEmail(command.userEmail());
        userService.changePassword(command.newPassword(), user);
        userService.saveUser(user);

    }

}
