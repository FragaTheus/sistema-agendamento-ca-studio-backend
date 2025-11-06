package br.com.castudio.sistema_agendamento.aplication.aplicationservices.recovery.implementation;

import br.com.castudio.sistema_agendamento.aplication.aplicationservices.recovery.command.RecoveryCommand;
import br.com.castudio.sistema_agendamento.aplication.aplicationservices.recovery.contract.RecoveryService;
import br.com.castudio.sistema_agendamento.aplication.domainservice.user.contract.UserService;
import br.com.castudio.sistema_agendamento.domain.entity.user.User;
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
