package com.dobudobu.ecommerce.Security.Jwt;

import com.dobudobu.ecommerce.Security.Service.UserDetailImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${jwt.expirationMs}")
    private int jwtExpirationMs;
    @Value("${jwt.secret}")
    private String jwtSecret;

    public boolean validateJwtToken(String authToken){
        try {
            Jwts.parser().setSigningKey(jwtSecret)
                    .parseClaimsJws(authToken);
            return true;
        }catch (SignatureException e){
            logger.error("Invalid jwt signature: {}", e.getMessage());
        }catch (MalformedJwtException e){
            logger.error("Invalid jwt token: {}", e.getMessage());
        }catch (ExpiredJwtException e){
            logger.error("jwt token expired: {}", e.getMessage());
        }catch (UnsupportedJwtException e){
            logger.error("jwt token unsupported: {}", e.getMessage());
        }catch (IllegalArgumentException e){
            logger.error("jwt is empty: {}", e.getMessage());
        }
        return false;
    }

    public String generateJwtToken(Authentication authentication){
        UserDetailImpl principal = (UserDetailImpl) authentication.getPrincipal();
        return Jwts.builder().setSubject((principal.getEmail()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getEmailFromJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
}
