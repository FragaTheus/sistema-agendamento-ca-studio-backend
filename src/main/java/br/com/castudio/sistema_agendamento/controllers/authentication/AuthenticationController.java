package br.com.castudio.sistema_agendamento.controllers.authentication;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.login.LoginRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.login.LoginResponse;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterResponse;
import br.com.castudio.sistema_agendamento.aplication.service.authentication.AuthenticationService;
import br.com.castudio.sistema_agendamento.aplication.service.login.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private LoginService loginService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticte(@Valid @RequestBody LoginRequest request){
        LoginResponse response = authenticationService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> createAdmin(
            @Valid @RequestBody RegisterRequest requestDto
    ){
        RegisterResponse admin = loginService.createAdmin(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin);
    }

}
