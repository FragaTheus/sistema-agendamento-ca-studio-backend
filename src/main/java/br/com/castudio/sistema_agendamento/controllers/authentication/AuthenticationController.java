package br.com.castudio.sistema_agendamento.controllers.authentication;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.login.LoginRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.login.LoginResponse;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.recovery.RecoveryRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterResponse;
import br.com.castudio.sistema_agendamento.aplication.service.authentication.login.LoginService;
import br.com.castudio.sistema_agendamento.aplication.service.authentication.recovery.RecoveryService;
import br.com.castudio.sistema_agendamento.aplication.service.authentication.register.RegisterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<LoginResponse> authenticte(@Valid @RequestBody LoginRequest request){
        LoginResponse response = loginService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> createAdmin(@Valid @RequestBody RegisterRequest requestDto){
        RegisterResponse admin = registerService.createAdmin(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin);
    }

    @PatchMapping("/recovery")
    public ResponseEntity<String> recoveryPassword(@Valid @RequestBody RecoveryRequest request){
        recoveryService.recoveryPassword(request);
        return ResponseEntity.ok("Senha alterada com sucesso! Todas as sessoes foram deslogadas, faca login novamente para continuar!");
    }

}
