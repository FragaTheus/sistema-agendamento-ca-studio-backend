package br.com.castudio.sistema_agendamento.aplication.service.key;

import br.com.castudio.sistema_agendamento.aplication.dto.key.KeyRequest;
import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import br.com.castudio.sistema_agendamento.domain.exceptions.business.WrongKeyException;
import br.com.castudio.sistema_agendamento.domain.exceptions.system.DataBaseException;
import br.com.castudio.sistema_agendamento.domain.repository.KeyRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class KeyServiceImpl implements KeyService{

    private final KeyRepository repository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public AdminKey insertKey(String key) {

        try{
            String passwordHash = encoder.encode(key);
            AdminKey adminKey = new AdminKey(passwordHash);
            repository.save(adminKey);
            return adminKey;
        }catch (Exception e){
            throw new DataBaseException();
        }

    }

    @Override
    public Optional<AdminKey> getKey() {
        try {
            return repository.findById(1L);
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public boolean keyIsMatch(String requestKey) {
        AdminKey adminKey = getKey()
                .orElseThrow(() -> new DataBaseException());
        if (!encoder.matches(requestKey, adminKey.getKey())){
            throw new WrongKeyException();
        }
        return true;
    }

    @Override
    public AdminKey setKey(KeyRequest request) {

        if (!keyIsMatch(request.currentKey())){
            throw new WrongKeyException();
        }
        String hashedValue = encoder.encode(request.newKey());
        AdminKey newAdminKey =  new AdminKey(hashedValue);
        repository.save(newAdminKey);
        return newAdminKey;

    }

}

