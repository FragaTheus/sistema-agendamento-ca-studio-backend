package br.com.castudio.sistema_agendamento.configs.init;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import br.com.castudio.sistema_agendamento.domain.repository.KeyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AdminKeyInitializer implements CommandLineRunner {

    private final KeyRepository adminKeyRepository;

    public AdminKeyInitializer(KeyRepository adminKeyRepository) {
        this.adminKeyRepository = adminKeyRepository;
    }

    @Value("${admin.key}")
    private String adminKeyValue;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (adminKeyRepository.selectKeyValue(1L).isEmpty()) {
            AdminKey key = new AdminKey(adminKeyValue);
            adminKeyRepository.saveKey(key);
        }
    }
}

