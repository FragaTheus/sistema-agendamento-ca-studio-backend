package br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.register;

import br.com.castudio.sistema_agendamento.domain.entity.User;

public record RegisterMapper() {

    public static User fromCommand(RegisterCommand command){
        return new User(null, command.username(), command.useremail(), command.confirmPassword());
    }

}
