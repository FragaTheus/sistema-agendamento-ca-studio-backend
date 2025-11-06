package br.com.castudio.sistema_agendamento.infra.adapter.in.web.controllers.authentication;

import br.com.castudio.sistema_agendamento.usermanager.aplication.aplicationservices.login.command.LoginCommand;
import br.com.castudio.sistema_agendamento.usermanager.aplication.aplicationservices.recovery.command.RecoveryCommand;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.login.LoginRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.recovery.RecoveryRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.response.MessageResponse;
import br.com.castudio.sistema_agendamento.usermanager.aplication.aplicationservices.login.contract.LoginService;
import br.com.castudio.sistema_agendamento.usermanager.aplication.aplicationservices.recovery.contract.RecoveryService;
import br.com.castudio.sistema_agendamento.usermanager.aplication.aplicationservices.register.contract.RegisterService;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.mapper.ControllerMapper;
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
    public ResponseEntity<MessageResponse<String>> authenticte(@Valid @RequestBody LoginRequest request){
        LoginCommand command = ControllerMapper.fromLoginRequest(request);
        String jwtToken = loginService.authenticate(command);
        String msg = "Login realizado com sucesso!";
        var response = ControllerMapper.toSuccess(msg, jwtToken);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<MessageResponse<String>> createAdmin(@Valid @RequestBody RegisterRequest request){
        var registerCommand = ControllerMapper.fromRegisterRequest(request);
        String jwtToken = registerService.registerUser(registerCommand);
        String msg = "Cadastro realizado com sucesso!";
        MessageResponse<String> response = ControllerMapper.toSuccess(msg, jwtToken);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/recovery")
    public ResponseEntity<MessageResponse<Object>> recoveryPassword(@Valid @RequestBody RecoveryRequest request){
        RecoveryCommand command = ControllerMapper.fromRecoveryRequest(request);
        recoveryService.recoveryPassword(command);
        String msg = "Senha alterada com sucesso! Realize o login com a nova senha cadastrada.";
        var response = ControllerMapper.toSuccess(msg, null);
        return ResponseEntity.ok(response);
    }

}
