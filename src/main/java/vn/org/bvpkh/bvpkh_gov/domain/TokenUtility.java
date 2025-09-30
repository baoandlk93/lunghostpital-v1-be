package vn.org.bvpkh.bvpkh_gov.domain;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;

import java.util.Date;

public class TokenUtility {
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenUtility.class);
    private static final String JWT_SECRET_KEY = "";
    private static final String JWT_ISSUER = "";
    private static final String JWT_EXPIRATION_IN_MS = "";
    private static final Integer STARTING_LETTER_IN_BEARER_TOKEN = 6;

    public static String generateToken(Authentication authentication) {
        LOGGER.debug("TokenUtility -> generateToken invoked!");
        Date createdDate = new Date();
        Date expiryDate = new Date(createdDate.getTime() + JWT_EXPIRATION_IN_MS);
        return Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET_KEY)
                .compact();
    }

    public static String getUsernameFromJwt(String jwtString) {
        LOGGER.debug("TokenUtility -> getUsernameFromJwt invoked!");
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET_KEY)
                .parseClaimsJws(jwtString)
                .getBody();
        return claims.getSubject();
    }

    public static String getTokenFromRequest(HttpServletRequest request) {
        LOGGER.debug("TokenUtility -> getTokenFromRequest invoked!");
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(STARTING_LETTER_IN_BEARER_TOKEN);
        }
        return null;
    }
}
