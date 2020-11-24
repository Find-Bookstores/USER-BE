package com.example.tamchack.utils;

import com.example.tamchack.exception.ExpiredTokenException;
import com.example.tamchack.exception.InvalidTokenException;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtil {
    private static String SECURITY_KEY = System.getenv("SECRET_KEY_BASE");

    private String generateToken(Object data, Long expire, String type){
        long nowMillis = System.currentTimeMillis();

        JwtBuilder builder = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date(nowMillis))
                .setHeaderParam("typ", type)
                .setSubject(data.toString())
                .claim("type", type)
                .setExpiration(new Date(nowMillis + expire))
                .signWith(SignatureAlgorithm.HS256, SECURITY_KEY.getBytes());

        return builder.compact();
    }

    public String getAccessToken(Object data){
        return generateToken(data, 1000L * 3600 * 24, "access_token");
    }

    public String getRefreshToken(Object data){
        return generateToken(data, 1000L * 3600 * 24 * 30, "refresh_token");
    }

    public String parseToken(String token){
        String result;
        try{
            result = Jwts.parser().setSigningKey(SECURITY_KEY.getBytes()).parseClaimsJws(token).getBody().getSubject();
            if(!Jwts.parser().setSigningKey(SECURITY_KEY.getBytes()).parseClaimsJws(token).getBody().get("type").equals("access_token")) throw new InvalidTokenException();
        } catch (ExpiredJwtException e){
            throw new ExpiredTokenException();
        } catch (MalformedJwtException e){
            throw new InvalidTokenException();
        }
        return token;
    }
}