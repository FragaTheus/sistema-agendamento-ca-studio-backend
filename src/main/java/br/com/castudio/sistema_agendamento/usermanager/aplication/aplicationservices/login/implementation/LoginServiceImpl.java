package br.com.castudio.sistema_agendamento.usermanager.aplication.aplicationservices.login.implementation;

import br.com.castudio.sistema_agendamento.usermanager.aplication.aplicationservices.login.command.LoginCommand;
import br.com.castudio.sistema_agendamento.usermanager.aplication.aplicationservices.login.contract.LoginService;
import br.com.castudio.sistema_agendamento.infra.configs.security.userdetails.UserDetailsServiceImpl;
import br.com.castudio.sistema_agendamento.infra.configs.security.jwt.JwtService;
import br.com.castudio.sistema_agendamento.usermanager.domain.exceptions.CredentialsException;
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
