package br.com.castudio.sistema_agendamento.aplication.service.update;

import br.com.castudio.sistema_agendamento.aplication.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateService {

    private final UserService userService;

    //Buscar dados na base
    //Validar senha antiga
    //Hashar nova senha
    //Alterar dados na entidade
    //Salvar na base

}
