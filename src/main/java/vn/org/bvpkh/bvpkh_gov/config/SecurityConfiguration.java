package vn.org.bvpkh.bvpkh_gov.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import vn.org.bvpkh.bvpkh_gov.security.jwt.JwtAuthFilter;
import vn.org.bvpkh.bvpkh_gov.security.jwt.JwtAuthEntryPoint;
import vn.org.bvpkh.bvpkh_gov.services.IUserPrincipleService;
import vn.org.bvpkh.bvpkh_gov.services.impl.UserPrincipleService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = {
        JwtAuthEntryPoint.class,
        UserPrincipleService.class})
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final IUserPrincipleService userPrincipalService;
    private final JwtAuthEntryPoint securityEntryPoint;
    private final JwtAuthFilter authenticationFilter;

    @Autowired
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userPrincipalService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class).build();
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.cors(AbstractHttpConfigurer::disable);

        httpSecurity
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.authorizeHttpRequests(
                req -> req.requestMatchers(
                                "/api/users",
                                "/api/roles",
                                "/api/departments",
                                "/api/equipments",
                                "/api/equipments/**",
                                "/api/categories",
                                "/api/warehouses",
                                "/api/auth/**"
                                )
                        .permitAll());
        httpSecurity.exceptionHandling(
                exception -> exception.authenticationEntryPoint(securityEntryPoint));

        httpSecurity.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        httpSecurity.rememberMe(req -> req.tokenRepository(new InMemoryTokenRepositoryImpl()));

        return httpSecurity.build();
    }

}
