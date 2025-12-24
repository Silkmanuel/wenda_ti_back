package kutuStech.wenda.infrastructure.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.security.Keys;
import kutuStech.wenda.adapters.output.config.TokenServicePort;

public class TokenServiceAdapter implements TokenServicePort{
    private final Key key = Keys.hmacShaKeyFor("chaveSuperSecretaComPeloMenos32Caracteres".getBytes());
    private final long accessTokenExpiration = 1000 * 60 * 60 * 24; // 7 days
    @Override
    public String generateAccessToken(String id) {
        return Jwts.builder()
                .setSubject(id)
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration))
                .signWith(key)
                .compact();    
    }

    @Override
    public Boolean validateAccessToken(String refreshToken) {
        try {
            extractAllClaims(refreshToken);
            return true;
        } catch (JwtException e) {
            return false;
        }    
    }

    @Override
    public String extractData(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    
}
