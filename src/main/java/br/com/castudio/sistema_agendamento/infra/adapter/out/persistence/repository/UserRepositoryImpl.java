package br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.repository;

import br.com.castudio.sistema_agendamento.usermanager.domain.entity.user.User;
import br.com.castudio.sistema_agendamento.infra.exceptions.DataBaseException;
import br.com.castudio.sistema_agendamento.usermanager.domain.repository.user.UserRepository;
import br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.jpa.UserJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
    public User findByEmail(String email) {
        return jpa.findByEmail(email).orElseThrow(()-> new DataBaseException());
    }

    @Override
    public void deleteUser(User user) {
         findByEmail(user.getEmail());
         try{
             jpa.delete(user);
         }catch (Exception e){
             throw new DataBaseException();
         }
    }


}
