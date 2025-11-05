package br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.repository;

import br.com.castudio.sistema_agendamento.domain.entity.User;
import br.com.castudio.sistema_agendamento.domain.exceptions.system.DataBaseException;
import br.com.castudio.sistema_agendamento.domain.repository.UserRepository;
import br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.jpa.UserJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpa jpa;

    @Override
    public User save(User user) {
        try {
            return jpa.save(user);
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public boolean existsByEmail(String email) {
        try{
            return jpa.existsByEmail(email);
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            return jpa.findByEmail(email);
        }catch (Exception e){
            throw new DataBaseException();
        }
    }


}
