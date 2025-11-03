package br.com.castudio.sistema_agendamento.aplication.service.authentication.login;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.login.LoginRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.login.LoginResponse;
import br.com.castudio.sistema_agendamento.configs.security.details.UserDetailsServiceImpl;
import br.com.castudio.sistema_agendamento.configs.security.jwt.JwtService;
import br.com.castudio.sistema_agendamento.domain.exceptions.business.CredentialsException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final JwtService jwtService;
    private final UserDetailsServiceImpl adminDetailsService;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse authenticate(LoginRequest request) {

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            var admin = adminDetailsService.loadUserByUsername(request.getEmail());
            String token = jwtService.gererateToken(admin);

            return new LoginResponse(token);
        }catch (Exception e){
            throw new CredentialsException();
        }

    }

}
