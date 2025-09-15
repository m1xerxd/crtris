package ru.nicetu.crtris.crtrisbackend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(header) && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try {
                Jws<Claims> jws = jwtService.parseToken(token);
                String username = jws.getBody().getSubject();
                String role = String.valueOf(jws.getBody().get("role"));

                var auth = new AbstractAuthenticationToken(
                        List.of(new SimpleGrantedAuthority("ROLE_" + role))) {
                    @Override public Object getCredentials() { return token; }
                    @Override public Object getPrincipal() { return username; }
                };
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                auth.setAuthenticated(true);

                org.springframework.security.core.context.SecurityContextHolder
                        .getContext().setAuthentication(auth);
            } catch (JwtException e) {
            }
        }
        chain.doFilter(request, response);
    }
}