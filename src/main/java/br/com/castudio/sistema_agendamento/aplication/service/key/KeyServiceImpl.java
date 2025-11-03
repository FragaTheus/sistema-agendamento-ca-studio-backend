package br.com.castudio.sistema_agendamento.aplication.service.key;

import br.com.castudio.sistema_agendamento.domain.entity.Key;
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
    public Key createKey(String key) {
        String passwordHash = encoder.encode(key);
        Key adminKey = new Key(passwordHash);
        repository.save(adminKey);
        return adminKey;
    }

    @Override
    public Optional<Key> getKey() {
        try {
            return repository.findById(1L);
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public boolean keyIsMatch(String requestKey) {
        Key key = getKey()
                .orElseThrow(() -> new NotRegisteredAdminKey());
        if (!encoder.matches(requestKey, key.getKey())){
            throw new WrongAdminKeyException();
        }
        return true;
    }

}

