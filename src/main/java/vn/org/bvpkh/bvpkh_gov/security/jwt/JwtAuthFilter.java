package vn.org.bvpkh.bvpkh_gov.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import vn.org.bvpkh.bvpkh_gov.domain.TokenUtility;
import vn.org.bvpkh.bvpkh_gov.services.IUserPrincipleService;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthFilter.class);
    private final JwtTokenProvider tokenProvider;
    private final IUserPrincipleService userPrincipalService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String token = TokenUtility.getTokenFromRequest(request);

            if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
                String username = TokenUtility.getUsernameFromJwt(token);
                UserDetails userDetails = userPrincipalService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, true, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            LOGGER.error("Could not set user authentication in security context!", e);
        }
        filterChain.doFilter(request, response);
    }
}
