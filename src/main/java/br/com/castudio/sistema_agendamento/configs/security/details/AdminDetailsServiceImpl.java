package br.com.castudio.sistema_agendamento.configs.security.details;

import br.com.castudio.sistema_agendamento.domain.repository.AdminRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminDetailsServiceImpl implements UserDetailsService {

    private final AdminRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var admin = repository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario nao encontrato" + username));

        return new AdminDetails(admin);
    }

}
