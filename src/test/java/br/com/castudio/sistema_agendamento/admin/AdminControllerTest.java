package br.com.castudio.sistema_agendamento.admin;

import br.com.castudio.sistema_agendamento.aplication.cases.interfaces.CreateAdminCase;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminResponseDto;
import br.com.castudio.sistema_agendamento.aplication.service.interfaces.AdminService;
import br.com.castudio.sistema_agendamento.infra.api.AdminController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AdminControllerTest {

    @Autowired
    private MockMvc http;

    @MockitoBean
    private CreateAdminCase createAdminCase;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createAdminSucessfully() throws Exception {
        CreateAdminRequestDto dto = new CreateAdminRequestDto(
                "Nome",
                "email@email.com",
                "Senha@123",
                "Senha@123"
        );

        UUID uuid = UUID.randomUUID();

        CreateAdminResponseDto responseDto = new CreateAdminResponseDto(
                uuid,
                "Nome",
                "email@email.com"
        );

        Mockito.when(createAdminCase.createAdmin(Mockito.any(CreateAdminRequestDto.class)))
                .thenReturn(responseDto);

        http.perform(post("/admin-accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.uuid").value(uuid.toString()))
                .andExpect(jsonPath("$.name").value("Nome"))
                .andExpect(jsonPath("$.email").value("email@email.com"));
    }

    @Test
    void createAdminNameBadRequest() throws Exception {
        CreateAdminRequestDto dto = new CreateAdminRequestDto(
                "",
                "email@email.com",
                "Senha@123",
                "Senha@123"
        );

        http.perform(post("/admin-accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createAdminPasswordBadRequest() throws Exception{
        CreateAdminRequestDto dto= new CreateAdminRequestDto(
                "Nome",
                "email@email.com",
                "senha123",
                "senha123"
        );

        http.perform(post("/admin-accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createAdminConfirmPasswordBadRequest() throws Exception{
        CreateAdminRequestDto dto= new CreateAdminRequestDto(
                "Nome",
                "email@email.com",
                "Senha@123",
                "Senha123"
        );

        http.perform(post("/admin-accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                        .andExpect(status().isBadRequest());

    }

}
