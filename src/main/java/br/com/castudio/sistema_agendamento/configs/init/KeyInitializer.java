package br.com.castudio.sistema_agendamento.configs.init;

import br.com.castudio.sistema_agendamento.aplication.service.key.KeyService;
import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class KeyInitializer implements CommandLineRunner {

    private final KeyService keyService;

    @Value("${admin.key}")
    private String adminKeyValue;

    public KeyInitializer(KeyService keyService) {
        this.keyService = keyService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (keyService.getKey().isEmpty()) {
            AdminKey firstKey = keyService.createKey(adminKeyValue);
        }
    }
}

