package br.com.castudio.sistema_agendamento.infra.adapter.in.web.controllers.authentication;

import br.com.castudio.sistema_agendamento.domain.entity.User;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.login.LoginRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.login.LoginResponse;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.recovery.RecoveryRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.register.RegisterResponse;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.message.MessageResponse;
import br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.login.LoginService;
import br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.recovery.RecoveryService;
import br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.register.RegisterService;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.mapper.AuthMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final LoginService loginService;
    private final RegisterService registerService;
    private final RecoveryService recoveryService;


    @PostMapping("/login")
    public ResponseEntity<MessageResponse<LoginResponse>> authenticte(@Valid @RequestBody LoginRequest request){
        LoginResponse LoginResponse = loginService.authenticate(request);
        String msg = "Login realizado com sucesso!";
        var response = MessageResponse.sucessWithData(msg, LoginResponse);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<MessageResponse<String>> createAdmin(@Valid @RequestBody RegisterRequest request){

        User newUser = AuthMapper.toEntity(request);
        String jwtToken = registerService.registerUser(newUser,
                                                    request.getConfirmPassword(),
                                                    request.getAdminKey());

        String msg = "Cadastro realizado com sucesso!";
        MessageResponse<String> response = AuthMapper.toSuccess(msg, jwtToken);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/recovery")
    public ResponseEntity<MessageResponse<Void>> recoveryPassword(@Valid @RequestBody RecoveryRequest request){
        recoveryService.recoveryPassword(request);
        String msg = "Senha alterada com sucesso! Realize o login com a nova senha cadastrada.";
        var response = MessageResponse.<Void>sucessWithoutData(msg);
        return ResponseEntity.ok(response);
    }

}
