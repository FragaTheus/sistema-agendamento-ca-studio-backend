package br.com.castudio.sistema_agendamento.configs.encoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EncoderConfig {

    @Bean
    public BCryptPasswordEncoder BCoder(){
        return new BCryptPasswordEncoder();
    }

}
