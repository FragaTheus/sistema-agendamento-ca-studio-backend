package br.com.castudio.sistema_agendamento.infra.configs.security.jwt;

import br.com.castudio.sistema_agendamento.infra.exceptions.InternalErrorException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtService {

    private static final long EXPIRATED_TIME = 1000 * 60 * 60;
    private static final String SECRET = "minhaChaveSecretaSuperLongaPraJWT";

    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String gererateToken(UserDetails userDetails) throws InternalErrorException {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATED_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token, String subject) throws InternalErrorException {
        try{
            String tokenSubject = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            return tokenSubject.equals(subject);
        } catch (JwtException | IllegalArgumentException e){
            return false;
        }
    }

    public String extractSubject(String token) throws InternalErrorException {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
