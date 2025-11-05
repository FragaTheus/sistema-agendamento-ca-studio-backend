package br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.recovery;

import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.recovery.RecoveryRequest;
import br.com.castudio.sistema_agendamento.aplication.service.user.UserService;
import br.com.castudio.sistema_agendamento.domain.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecoveryServiceImpl implements RecoveryService{

    private final UserService userService;

    @Override
    public void recoveryPassword(RecoveryRequest request) {

        User user = userService.findUserByEmail(request.getEmail());
        String hashedNewPassword = userService.encodePassword(request.getNewPassword());
        user.setPassword(hashedNewPassword);
        userService.saveUser(user);

    }

}
