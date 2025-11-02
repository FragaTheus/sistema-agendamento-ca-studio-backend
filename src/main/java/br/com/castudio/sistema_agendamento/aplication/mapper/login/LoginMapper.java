package br.com.castudio.sistema_agendamento.aplication.mapper.login;


import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;


public class LoginMapper {

    public static Admin toEntity(RegisterRequest requestDto, String hashedPassword){
        return Admin.builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(hashedPassword)
                .build();
    }

}
