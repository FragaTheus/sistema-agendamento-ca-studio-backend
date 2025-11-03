package br.com.castudio.sistema_agendamento.aplication.mapper.login;


import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.domain.entity.User;


public class AdminMapper {

    public static User registerToEntity(RegisterRequest requestDto, String hashedPassword){
        return User.builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(hashedPassword)
                .build();
    }



}
