package com.example.newspaperapp.security;

import com.example.newspaperapp.services.AuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final AuthenticationService authenticationService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            // Extract token from request with method that we created
            String token = extractToken(request);

            if (token != null) {
                var userDetails = authenticationService.validateToken(token);

                var authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null,
                        userDetails.getAuthorities()); // permissions ose rolet e userit

                SecurityContextHolder.getContext().setAuthentication(authentication);

                if (userDetails instanceof AppUserDetails) {
                    // per cdo requst bashkangjitja edhe userId
                    request.setAttribute("userId", ((AppUserDetails) userDetails).getId());
                }
            }
        } catch (Exception e) {
            log.warn("Invalid token {}", e.getMessage());
        }

        // E aktivizon filterin
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        // Tokeni dergohet ne headerin Authorization
        // "Bearer token" => Bearer djhwdhawjkdhasdhawjkdhawjkdhawjkdaw

        // Tokeni vjen prej header Authorization
        // Bearer djhwdhawjkdhasdhawjkdhawjkdhawjkdaw
        String bearerToken = request.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }
}