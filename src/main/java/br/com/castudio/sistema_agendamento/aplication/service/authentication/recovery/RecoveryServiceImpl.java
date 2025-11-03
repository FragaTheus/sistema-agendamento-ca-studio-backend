package br.com.castudio.sistema_agendamento.aplication.service.authentication.recovery;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.recovery.RecoveryRequest;
import br.com.castudio.sistema_agendamento.aplication.service.user.UserService;
import br.com.castudio.sistema_agendamento.domain.entity.User;
import br.com.castudio.sistema_agendamento.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecoveryServiceImpl implements RecoveryService{

    private final UserService userService;

    @Override
    public void recoveryPassword(RecoveryRequest request) {

        User user = repository.findByEmail(request.getEmail()).orElseThrow(()-> new RuntimeException("Email nao existe no sistema"));

        String hashedNewPassword = userService.encodePassword(request.getNewPassword());

        user.setPassword(hashedNewPassword);

        userService.saveUser(user);

    }

}
