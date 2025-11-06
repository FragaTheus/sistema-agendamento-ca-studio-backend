package br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.managerprocedure.delete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DeleteProcedureRequest {

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,30}$",
            message = "Formato de chave administrativa invalida"
    )

    private final String AdminKey;

}
