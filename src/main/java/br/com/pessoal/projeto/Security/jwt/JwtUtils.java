package br.com.pessoal.projeto.Security.jwt;

import br.com.pessoal.projeto.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    @Value("${projeto.jwtSecret}")
    private String jwtSecret;
    @Value("${projeto.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String GenerateTokenFromUserDetailsImpl(UserDetailsImpl userData) {
        return Jwts.builder().setSubject(userData.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(getSigninKey(), SignatureAlgorithm.HS512)
                .compact();
    }
    public Key getSigninKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUserNameFromJwtToken(String token) {
        System.out.println();
        return Jwts.parser().setSigningKey(getSigninKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }
    public boolean validateJwtToken(String authToken) {
        try {
            System.out.println();
            Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
            return true;
        }catch (MalformedJwtException e) {
            System.out.println("token invalido "+  e.getMessage());
        }catch (ExpiredJwtException | UnsupportedJwtException e ) {
            System.out.println("token expirado ou nao suportado" + e.getMessage());
        } catch (IllegalArgumentException e ) {
            System.out.println("token errado " + e.getMessage());
        }
        return false;
    }
}

