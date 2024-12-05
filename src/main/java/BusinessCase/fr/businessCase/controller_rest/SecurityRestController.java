package BusinessCase.fr.businessCase.controller_rest;


import BusinessCase.fr.businessCase.Security.JwtAuthenticatorService;
import BusinessCase.fr.businessCase.Service.UserService;
import BusinessCase.fr.businessCase.dto.User.UserCreateDTO;
import BusinessCase.fr.businessCase.dto.User.UserLoginDTO;
import BusinessCase.fr.businessCase.entity.User;
import BusinessCase.fr.businessCase.response.JwtResponse;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecurityRestController {

    private final UserService userService;
    private final JwtAuthenticatorService jwtAuthenticatorService;

    @PostMapping("/api/auth/register")
    public User register(@Valid @RequestBody UserCreateDTO user) {
        return userService.create(user);
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserLoginDTO user) {
        return jwtAuthenticatorService.authenticate(user);
    }
}
