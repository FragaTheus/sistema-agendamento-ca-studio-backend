package br.com.castudio.sistema_agendamento.infra.configs.init;

import br.com.castudio.sistema_agendamento.aplication.domainservice.key.AdminKeyService;
import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class KeyInitializer implements CommandLineRunner {

    private final AdminKeyService adminKeyService;

    @Value("${user.key}")
    private String adminKeyValue;

    public KeyInitializer(AdminKeyService adminKeyService) {
        this.adminKeyService = adminKeyService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (adminKeyService.getKey().isEmpty()) {
            AdminKey firstAdminKey = adminKeyService.insertKey(adminKeyValue);
        }
    }
}

