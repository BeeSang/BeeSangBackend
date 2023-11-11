package com.example.beesang.service.auth;

import com.example.beesang.domain.User;
import com.example.beesang.exception.ExceptionErrorCode;
import com.example.beesang.exception.exceptions.AuthException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtService {


    @Value("${jwt-access-expiration}")
    private Long accessExp;

    @Value("${jwt-secret-key}")
    private String secretKey;

    @Value("${jwt-issuer}")
    private String issuer;

    //key 발급
    public String generateAccessToken(User user, ExtraClaims claims) {

        Map<String, Object> extraClaims = new HashMap<>();
//        extraClaims.put("userId", claims.getUserId());

        return Jwts.builder().setClaims(extraClaims)
                .setSubject(user.getId().toString())
                .setIssuer(issuer)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * accessExp))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //Key 해석
    public String getUserId(HttpHeaders header) {
        String accessToken = Objects.requireNonNull(header.getFirst("authorization")).substring("Bearer ".length());
        return getClaim(accessToken, Claims::getSubject);
    }

    public <T> T getClaim(String accessToken, Function<Claims, T> claimResolver) {
        final Claims claims = getAllClaims(accessToken);
        return claimResolver.apply(claims);
    }

    public Claims getAllClaims(String accessToken) {
        try {
            return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(accessToken)
                .getBody();
        } catch(ExpiredJwtException e) {
            throw new AuthException(ExceptionErrorCode.EXPIRED_ACCESS_TOKEN_EXCEPTION, 403);
        } catch(UnsupportedJwtException e) {
            throw new AuthException(ExceptionErrorCode.UNSUPPORTED_JWT_EXCEPTION, 403);
        } catch(MalformedJwtException e) {
            throw new AuthException(ExceptionErrorCode.MALFORMED_JWT_EXCEPTION, 403);
        } catch(SignatureException e) {
            throw new AuthException(ExceptionErrorCode.SIGNATURE_EXCEPTION, 403);
        } catch(IllegalArgumentException e) {
            throw new AuthException(ExceptionErrorCode.ILLEGAL_ARGUMENT_EXCEPTION, 403);
        }
    }
}
