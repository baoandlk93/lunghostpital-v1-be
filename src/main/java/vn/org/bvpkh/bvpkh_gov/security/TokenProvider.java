package vn.org.bvpkh.bvpkh_gov.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenProvider.class);
    @Value("${app.jwtSecret}")
    private String jwtSecretKey;

    public boolean validateToken(String jwtString, HttpServletRequest request) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecretKey)
                    .parseClaimsJws(jwtString);
            return true;
        } catch (SignatureException ex) {
            LOGGER.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            LOGGER.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            // When token expired but user have not logout yet,
            // Call refreshLogin to refresh token for this user
            LOGGER.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            LOGGER.error("JWT claims string is empty.");
        }
        return false;
    }
}
