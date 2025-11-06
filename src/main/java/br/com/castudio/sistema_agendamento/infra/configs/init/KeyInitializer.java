package br.com.castudio.sistema_agendamento.infra.configs.init;

import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.domainservice.key.contract.AdminKeyService;
import br.com.castudio.sistema_agendamento.contexts.usermanager.domain.entity.adminkey.AdminKey;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class KeyInitializer {

    private final AdminKeyService adminKeyService;
    private final String adminKeyValue;


    public KeyInitializer(AdminKeyService adminKeyService,
                          @Value("${user.adminKey}") String adminKeyValue) {
        this.adminKeyService = adminKeyService;
        this.adminKeyValue = adminKeyValue;
    }

    @EventListener(org.springframework.boot.context.event.ApplicationReadyEvent.class)
    @Transactional
    public void init() {
        AdminKey firstAdminKey = adminKeyService.setKey(adminKeyValue);
        adminKeyService.saveAdminKey(firstAdminKey);
    }
}
