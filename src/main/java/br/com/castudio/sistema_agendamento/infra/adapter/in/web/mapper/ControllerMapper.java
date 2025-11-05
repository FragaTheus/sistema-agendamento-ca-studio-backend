package br.com.castudio.sistema_agendamento.infra.adapter.in.web.mapper;

import br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.login.LoginCommand;
import br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.recovery.RecoveryCommand;
import br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.register.RegisterCommand;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.login.LoginRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.recovery.RecoveryRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.message.MessageResponse;


public record ControllerMapper() {

    public static RegisterCommand fromRegisterRequest(RegisterRequest request){
        return RegisterCommand.builder()
                .username(request.getName())
                .useremail(request.getEmail())
                .userPassword(request.getPassword())
                .confirmPassword(request.getConfirmPassword())
                .adminKey(request.getAdminKey())
                .build();
    }

    public static LoginCommand fromLoginRequest(LoginRequest request){
        return LoginCommand.builder()
                .useremail(request.getEmail())
                .userPassword(request.getPassword())
                .build();
    }

    public static RecoveryCommand fromRecoveryRequest(RecoveryRequest request){
        return RecoveryCommand.builder()
                .userEmail(request.getEmail())
                .newPassword(request.getNewPassword())
                .build();
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
