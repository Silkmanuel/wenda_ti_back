package kutuStech.wenda.infrastructure.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyAutenticationFilter extends OncePerRequestFilter {
    private static final String API_KEY = "wendati552001@gmail.com";
    private static final String HEADER_NAME = "wenda-api-key";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                String path = request.getRequestURI();

                if (path.startsWith("/swagger-ui") || 
                    path.startsWith("/v3/api-docs") || 
                    path.startsWith("/swagger-ui.html") || 
                    path.startsWith("/webjars") ||
                    path.startsWith("/swagger-resources")
                ) {
                    filterChain.doFilter(request, response);
                    return;
                }
                String apiKey = request.getHeader(HEADER_NAME);
                if (apiKey == null || !apiKey.equals(API_KEY)) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("REQUEST UNAUTHORIZED: wenda api key invalid: "+ apiKey);
                    return;
                }
                filterChain.doFilter(request, response);
    }
    
}
