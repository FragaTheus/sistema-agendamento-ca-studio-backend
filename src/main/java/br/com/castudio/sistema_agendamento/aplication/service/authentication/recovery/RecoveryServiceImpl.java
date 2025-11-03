package br.com.castudio.sistema_agendamento.aplication.service.authentication.recovery;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.recovery.RecoveryRequest;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import br.com.castudio.sistema_agendamento.domain.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecoveryServiceImpl implements RecoveryService{

    private final AdminRepository repository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public void recoveryPassword(RecoveryRequest request) {

        Admin admin = repository.findByEmail(request.getEmail()).orElseThrow(()-> new RuntimeException("Email nao existe no sistema"));

        String hashedNewPassword = encoder.encode(request.getNewPassword());

        admin.setPassword(hashedNewPassword);

        repository.save(admin);

    }

}
