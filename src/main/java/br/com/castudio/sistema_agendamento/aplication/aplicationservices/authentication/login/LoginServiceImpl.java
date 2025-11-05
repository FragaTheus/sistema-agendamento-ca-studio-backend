package br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.login;

import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.login.LoginRequest;
import br.com.castudio.sistema_agendamento.infra.configs.security.details.UserDetailsServiceImpl;
import br.com.castudio.sistema_agendamento.infra.configs.security.jwt.JwtService;
import br.com.castudio.sistema_agendamento.domain.exceptions.business.CredentialsException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final JwtService jwtService;
    private final UserDetailsServiceImpl adminDetailsService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String authenticate(LoginCommand command) {

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(command.useremail(), command.userPassword())
            );

            UserDetails user = adminDetailsService.loadUserByUsername(command.useremail());
            return jwtService.gererateToken(user);

        }catch (Exception e){
            throw new CredentialsException();
        }

    }

}
