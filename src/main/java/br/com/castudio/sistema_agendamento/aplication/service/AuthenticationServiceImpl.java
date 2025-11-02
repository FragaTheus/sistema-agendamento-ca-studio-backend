package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.AuthenticationRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.AuthenticationResponse;
import br.com.castudio.sistema_agendamento.configs.security.details.AdminDetailsServiceImpl;
import br.com.castudio.sistema_agendamento.configs.security.jwt.JwtService;
import br.com.castudio.sistema_agendamento.domain.exceptions.WrongCredentialsException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AdminDetailsServiceImpl adminDetailsService;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            var admin = adminDetailsService.loadUserByUsername(request.getEmail());
            String token = jwtService.gererateToken(admin);

            return new AuthenticationResponse(token);
        }catch (Exception e){
            throw new WrongCredentialsException();
        }

    }

}
