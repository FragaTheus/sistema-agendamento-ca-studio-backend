package br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.request.procedure;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class CreateProcedureRequest {

    @NotBlank
    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ\\s]{2,50}$",
            message = "Nome deve conter apenas letras e espaços, entre 2 e 50 caracteres"
    )
    private final String name;

    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ0-9.,;:!?'\"\\s]{0,255}$",
            message = "Descrição deve ter no máximo 255 caracteres e conter apenas letras, números e pontuação básica"
    )
    private final String description;

    @NotBlank
    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ\\s]{2,30}$",
            message = "Categoria deve conter apenas letras e espaços, entre 2 e 30 caracteres"
    )
    private final String category;

    @NotNull
    private final BigDecimal price;

    @NotNull
    private final Integer duration;
}
