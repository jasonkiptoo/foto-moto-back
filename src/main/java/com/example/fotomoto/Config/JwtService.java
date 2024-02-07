package com.example.fotomoto.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Component
public class JwtService {
    @Value("${spring.application.secret-key}")
    private String SECRET_KEY;
//    private static final String Secret_key="2bvhQJ7TnyKZseqJVaCBO5rWKnk5m3ax";


    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);

    }

    public String generateToken( UserDetails userDetails){
        return generateToken(new HashMap<>() , userDetails);
    }


    public String generateToken(
            Map<String, Object> claims,
            UserDetails userDetails
    ) {
        return
                Jwts.builder()
                        .setClaims(claims)
                        .setSubject(userDetails.getUsername())
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                        .signWith(SignatureAlgorithm.HS256, getSignKey())
                        .compact();
}
//validate token
    public boolean isValidToken(String token, UserDetails userDetails){
        final  String username =extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        return  extractExpiration(token).before(new  Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(getSignKey())
                .parseClaimsJws(token)
                .getBody();
    }
// Assuming Secret_key is a Base64-encoded string representing the secret key

    private byte[] getSignKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY);

        return keyBytes;
    }
}
