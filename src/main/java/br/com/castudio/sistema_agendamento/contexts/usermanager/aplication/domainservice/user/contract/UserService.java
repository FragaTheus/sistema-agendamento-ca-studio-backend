package br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.domainservice.user.contract;

import br.com.castudio.sistema_agendamento.contexts.usermanager.domain.entity.user.User;

public interface UserService {

    public User saveUser(User user);

    public User findUserByEmail(String email);

    public void existsUserByEmail(String email);

    public void confirmInputPasswordIsMatch(String password, String confirmPassword);

    public void validatePassword(String password, User user);

    public void changeName(String name, User user);

    public void changePassword(String password, User user);

    public void deleteUser(User user);
}
