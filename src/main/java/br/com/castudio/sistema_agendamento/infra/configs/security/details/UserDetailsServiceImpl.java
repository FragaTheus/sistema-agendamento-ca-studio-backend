package br.com.castudio.sistema_agendamento.infra.configs.security.details;

import br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.jpa.UserJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserJpa repository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("Credenciais invalidas"));

        return new UserDetails(user);
    }

}
