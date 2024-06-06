package com.backend.gg.security.config;

import com.backend.gg.security.entity.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter authenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    /**
     * Configuración del filtro de seguridad y la gestión de sesiones.
     *
     * @param httpSecurity Configuración de seguridad HTTP.
     * @return Cadena de filtros de seguridad.
     * @throws Exception Si hay un error al configurar la seguridad HTTP.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/products/**").permitAll()
                                .requestMatchers( "/api/v1/**").hasAuthority(RoleName.ADMIN.name())
                                .requestMatchers("/cart/**").hasAuthority(RoleName.CUSTOMER.name())
                                .requestMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**").permitAll()
                                .anyRequest().authenticated()
                ).sessionManagement(
                        session -> {
                            session
                                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                        }
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}