package br.com.castudio.sistema_agendamento.controllers.authentication;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.login.LoginRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.login.LoginResponse;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.recovery.RecoveryRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterResponse;
import br.com.castudio.sistema_agendamento.aplication.dto.message.MessageResponse;
import br.com.castudio.sistema_agendamento.aplication.service.authentication.login.LoginService;
import br.com.castudio.sistema_agendamento.aplication.service.authentication.recovery.RecoveryService;
import br.com.castudio.sistema_agendamento.aplication.service.authentication.register.RegisterService;
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
    public ResponseEntity<MessageResponse<RegisterResponse>> createAdmin(@Valid @RequestBody RegisterRequest requestDto){
        RegisterResponse registerResponse = registerService.createAdmin(requestDto);
        String msg = "Cadastro realizado com sucesso!";
        var response = MessageResponse.sucessWithData(msg, registerResponse);
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
