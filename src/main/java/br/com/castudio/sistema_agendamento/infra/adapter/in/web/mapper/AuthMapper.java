package br.com.castudio.sistema_agendamento.infra.adapter.in.web.mapper;

import br.com.castudio.sistema_agendamento.domain.entity.User;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.message.MessageResponse;


public record AuthMapper() {

    public static User toEntity(RegisterRequest request){
        return new User(request.getName(), request.getEmail(), request.getPassword());
    }

    public static <T> MessageResponse<T> toSuccess(String msg, T data) {
        return MessageResponse.<T>builder()
                .sucess(true)
                .msg(msg)
                .data(data)
                .build();
    }

    public static <T> MessageResponse<T> toError(String msg, T data) {
        return MessageResponse.<T>builder()
                .sucess(false)
                .msg(msg)
                .data(data)
                .build();
    }

}
