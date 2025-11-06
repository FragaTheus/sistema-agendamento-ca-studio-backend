package br.com.castudio.sistema_agendamento.usermanager.aplication.domainservice.key.implementation;

import br.com.castudio.sistema_agendamento.usermanager.aplication.domainservice.key.command.ChangeKeyCommand;
import br.com.castudio.sistema_agendamento.usermanager.aplication.domainservice.key.contract.AdminKeyService;
import br.com.castudio.sistema_agendamento.usermanager.domain.entity.adminkey.AdminKey;
import br.com.castudio.sistema_agendamento.usermanager.domain.exceptions.WrongKeyException;
import br.com.castudio.sistema_agendamento.usermanager.domain.repository.adminkey.AdminKeyRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminKeyServiceImpl implements AdminKeyService {

    private final AdminKeyRepository adminKeyRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public AdminKey saveAdminKey(AdminKey adminKey) {
        return adminKeyRepository.save(adminKey);
    }

    @Override
    public AdminKey findKeyById() {
        return adminKeyRepository.findById((byte) 1);
    }

    @Override
    public boolean validateKey(String adminKey) {
        AdminKey currentKey = findKeyById();
        boolean isMatch = encoder.matches(adminKey, currentKey.getKeyValue());
        if (!isMatch){
            throw new WrongKeyException();
        }
        return true;
    }

    @Override
    public AdminKey setKey(String newAdminKey) {
        String hashedKey = encoder.encode(newAdminKey);
        AdminKey adminKey = new AdminKey(hashedKey);
        saveAdminKey(adminKey);
        return adminKey;
    }

    @Override
    public void changeAdminKey(ChangeKeyCommand command){
        validateKey(command.currentKey());
        AdminKey newKey = setKey(command.newKey());
        saveAdminKey(newKey);

    }

}

