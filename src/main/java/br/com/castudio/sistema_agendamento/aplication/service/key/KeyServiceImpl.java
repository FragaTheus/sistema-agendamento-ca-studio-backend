package br.com.castudio.sistema_agendamento.aplication.service.key;

import br.com.castudio.sistema_agendamento.domain.entity.Key;
import br.com.castudio.sistema_agendamento.domain.exceptions.business.WrongKeyException;
import br.com.castudio.sistema_agendamento.domain.exceptions.system.DataBaseException;
import br.com.castudio.sistema_agendamento.domain.repository.KeyRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
@AllArgsConstructor
public class KeyServiceImpl implements KeyService{

    private final KeyRepository repository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public Key insertKey(String key) {

        try{
            String passwordHash = encoder.encode(key);
            Key adminKey = new Key(passwordHash);
            repository.save(adminKey);
            return adminKey;
        }catch (Exception e){
            throw new DataBaseException();
        }

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
                .orElseThrow(() -> new DataBaseException());
        if (!encoder.matches(requestKey, key.getKey())){
            throw new WrongKeyException();
        }
        return true;
    }

}

