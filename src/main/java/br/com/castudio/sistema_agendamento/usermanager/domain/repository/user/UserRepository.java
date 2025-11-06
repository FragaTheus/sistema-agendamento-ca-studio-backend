package br.com.castudio.sistema_agendamento.usermanager.domain.repository.user;

import br.com.castudio.sistema_agendamento.usermanager.domain.entity.user.User;


public interface UserRepository {

    public User save(User user);

    public User findByEmail(String email);

    public void deleteUser(User user);

    public boolean existsByEmail(String email);


}
