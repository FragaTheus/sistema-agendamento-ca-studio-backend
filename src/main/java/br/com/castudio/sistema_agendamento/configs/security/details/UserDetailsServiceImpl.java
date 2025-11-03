package br.com.castudio.sistema_agendamento.configs.security.details;

import br.com.castudio.sistema_agendamento.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var admin = repository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario nao encontrato" + username));

        return new UserDetails(admin);
    }

}
