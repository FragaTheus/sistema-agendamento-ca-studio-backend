package br.com.castudio.sistema_agendamento.domain.repository.user;

import br.com.castudio.sistema_agendamento.domain.entity.user.User;


public interface UserRepository {

    public User save(User user);

    public User findByEmail(String email);

    public void deleteUser(User user);

    public boolean existsByEmail(String email);


}
