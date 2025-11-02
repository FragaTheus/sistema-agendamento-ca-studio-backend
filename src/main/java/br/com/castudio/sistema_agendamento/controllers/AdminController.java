package br.com.castudio.sistema_agendamento.controllers;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountResponse;
import br.com.castudio.sistema_agendamento.aplication.service.CreateAdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/admin-accounts")
public class AdminController {

    private CreateAdminService createAdminService;

    @PostMapping
    public ResponseEntity<CreateAccountResponse> createAdmin(
            @Valid @RequestBody CreateAccountRequest requestDto
    ){
        CreateAccountResponse admin = createAdminService.createAdmin(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin);
    }
}
