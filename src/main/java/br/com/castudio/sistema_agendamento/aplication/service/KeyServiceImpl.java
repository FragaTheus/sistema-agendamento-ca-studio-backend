package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import br.com.castudio.sistema_agendamento.domain.exceptions.DataBaseException;
import br.com.castudio.sistema_agendamento.domain.exceptions.NotRegisteredAdminKey;
import br.com.castudio.sistema_agendamento.domain.exceptions.WrongAdminKeyException;
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
    public AdminKey createKey(String key) {
        String passwordHash = encoder.encode(key);
        AdminKey adminKey = new AdminKey(passwordHash);
        repository.save(adminKey);
        return adminKey;
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
                .orElseThrow(() -> new NotRegisteredAdminKey());
        if (!encoder.matches(requestKey, adminKey.getKey())){
            throw new WrongAdminKeyException();
        }
        return true;
    }

}

