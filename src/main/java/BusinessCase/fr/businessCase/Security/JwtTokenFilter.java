package BusinessCase.fr.businessCase.Security;

import BusinessCase.fr.businessCase.Service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService userService;

    // List of endpoints that should skip JWT verification
    private static final List<String> NON_AUTHENTICATED_ENDPOINTS = Arrays.asList(
            "/api/auth/login",
            "/api/auth/register",
            "/api/power",
            "/api/chargingstation"

    );

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain
    ) throws ServletException, IOException {
        String requestPath = request.getRequestURI();

        // Skip JWT validation for permitted paths
        if (NON_AUTHENTICATED_ENDPOINTS.stream().anyMatch(requestPath::equals)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Get the "Authorization" header
        String authorizationHeader = request.getHeader("Authorization");
        String token;
        String username;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);

            try {
                // Extract the username and validate token if user is not already authenticated
                if (SecurityContextHolder.getContext().getAuthentication() == null) {
                    username = jwtService.extractUserName(token);

                    if (username != null) {
                        UserDetails userDetails = userService.loadUserByUsername(username);

                        if (jwtService.validateToken(token, userDetails)) {
                            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                    userDetails, null, userDetails.getAuthorities()
                            );
                            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authToken);
                        }
                    }
                }
            } catch (Exception e) {
                // Log and ignore token validation errors to prevent interruption
                System.err.println("JWT validation failed: " + e.getMessage());
            }
        }

        // Continue with the request
        filterChain.doFilter(request, response);
    }
}
