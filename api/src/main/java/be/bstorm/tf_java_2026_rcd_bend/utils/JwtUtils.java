package be.bstorm.tf_java_2026_rcd_bend.utils;

import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtils {

    private final JwtBuilder builder;

    private final JwtParser parser;

    public JwtUtils() {

        SecretKey secret = new SecretKeySpec("Yabadabadooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo".getBytes(StandardCharsets.UTF_8), "HmacSHA256");

        this.builder = Jwts.builder().signWith(secret);
        this.parser = Jwts.parser().verifyWith(secret).build();
    }

    public String generateToken(User u){
        return builder
                .subject(u.getUsername())
                .claim("id",u.getId())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400 * 1000L))
                .compact();
    }

    public Claims getClaims(String token){
        return parser.parseSignedClaims(token).getPayload();
    }

    public Long getId(String token){
        return getClaims(token).get("id", Long.class);
    }

    public String getUsername(String token){
        return getClaims(token).getSubject();
    }

    public boolean isValid(String token){
        Claims claims = getClaims(token);
        Date now = new Date();
        return now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }
}