package pak.helper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenHelper {

    @Value("${jwt.secret.key}")
    private String secret;

    @Value("${jwt.token.expiration.hours}")
    private long tokenExpirationHours;

    public String extractUsernameWithValidation(String token) {
        return extractSpecificClaim(token, Claims::getSubject);
    }

    public Date extractExpirationWithValidation(String token) {
        return extractSpecificClaim(token, Claims::getExpiration);
    }

    public Date extractIssuedAtWithValidation(String token) {
        return extractSpecificClaim(token, Claims::getIssuedAt);
    }

    private <T> T extractSpecificClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractClaims(token);
        return claimsResolver.apply(claims);
    }

    // among exceptions are: SignatureException and ExpiredJwtException
    private Claims extractClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        long tokenExpirationMillis = tokenExpirationHours * 60 * 60 * 1000;
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpirationMillis))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

}
