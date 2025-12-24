package kutuStech.wenda.infrastructure.security;


import java.io.IOException;
import java.util.Collections;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kutuStech.wenda.adapters.output.config.TokenServicePort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAutenticationFilter extends OncePerRequestFilter {
    private final TokenServicePort tokenService;
//    /api/user/login
//    /api/user/register
//    /api/word/all
//    /api/word/search

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                String path = request.getRequestURI();
                if (path.startsWith("/swagger-ui") || 
                    path.startsWith("/v3/api-docs") || 
                    path.startsWith("/swagger-ui.html") || 
                    path.startsWith("/webjars") ||
                    path.startsWith("/swagger-resources") ||
                    path.startsWith("/api/user/register") ||
                    path.startsWith("/api/user/login") ||
                    path.startsWith("/api/word/all") ||
                    path.startsWith("/api/word/search/") ||
                    path.startsWith("/api/suggestion/available")
                    ) {
                    filterChain.doFilter(request, response);
                    return;
                }
        String authHeader = request.getHeader("Authorization");
        System.out.println("=====Authorization Header: " + authHeader);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("REQUEST UNAUTHORIZED: token access invalid");
            return;
        }

        String token = authHeader.substring(7);

        try {
            if (tokenService.validateAccessToken(token)) {
                String id = tokenService.extractData(token);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                id,
                                null,
                                Collections.singletonList(new SimpleGrantedAuthority(id))
                        );

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else{
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("REQUEST UNAUTHORIZED: token access invalid");
                return;
            }
        } catch (JwtException ex) {
            // Token inválido ou expirado → só loga ou retorna 401 depois
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request, response);
    }
}
