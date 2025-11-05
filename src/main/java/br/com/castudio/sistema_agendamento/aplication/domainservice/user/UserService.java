package br.com.castudio.sistema_agendamento.aplication.domainservice.user;

import br.com.castudio.sistema_agendamento.domain.entity.User;

public interface UserService {

    public User saveUser(User user);

    public User findUserByEmail(String email);

    public boolean existsUserByEmail(String email);

    public String encodePassword(String rawPassword);

    public void confirmInputPasswordIsMatch(String password, String confirmPassword);

    public void validatePassword(String password, User user);

    public void changePassword(String newPassword, User user);

    public void changeName(String name, User user);

}
