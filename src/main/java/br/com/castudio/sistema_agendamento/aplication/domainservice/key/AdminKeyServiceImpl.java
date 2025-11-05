package br.com.castudio.sistema_agendamento.aplication.domainservice.key;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import br.com.castudio.sistema_agendamento.domain.exceptions.business.WrongKeyException;
import br.com.castudio.sistema_agendamento.domain.repository.AdminKeyRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminKeyServiceImpl implements AdminKeyService {

    private final BCryptPasswordEncoder encoder;
    private final AdminKeyRepository adminKeyRepository;

    @Override
    public AdminKey findKeyById() {
        return adminKeyRepository.findById((byte) 1);
    }

    @Override
    public void keyIsMatch(String adminKey, String confirmAdminKey) {
        if (!adminKey.equals(confirmAdminKey)){
            throw new WrongKeyException();
        }
    }

    @Override
    public AdminKey setKey(String newAdminKey) {
        newAdminKey = encoder.encode(newAdminKey);
        return new AdminKey(newAdminKey);
    }

    @Override
    public void changeAdminKey(ChangeKeyCommand command){
        var currentKey = findKeyById();
        if ()
    }

}

