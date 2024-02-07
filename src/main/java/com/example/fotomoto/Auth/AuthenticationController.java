package com.example.fotomoto.Auth;

import com.example.fotomoto.Responses.AuthenticationResponse;
import com.example.fotomoto.Responses.RegisterResponse;
import com.example.fotomoto.user.User;
import com.example.fotomoto.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Base64;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository; // Inject UserRepository
    private final AuthenticationResponse authenticationResponse;


    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request) {
        // Check if email exists before registering
        if (userRepository.existsByEmail(request.getEmail())) {
            String errorMessage = "Email " + request.getEmail() + " already exists";
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ErrorResponse(errorMessage));
        }
        AuthenticationResponse registrationResponse = authenticationService.register(request);
        String successMessage = "Registration successful for user: " + request.getEmail();
        return ResponseEntity.ok(new SuccessResponse(successMessage, registrationResponse));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        log.info("CDSCSC {}", authorizationHeader);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Basic ")) {
            // Unauthorized if Authorization header is missing or not in expected format
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Extract base64 encoded credentials from Authorization header
        String base64Credentials = authorizationHeader.substring("Basic ".length());
        String credentials = new String(Base64.getDecoder().decode(base64Credentials));
        String[] parts = credentials.split(":", 2); // Split into username and password
        String username = parts[0];
        String password = parts[1];

        AuthenticationResponse loginResponse = authenticationService.authenticate(username, password);
        log.info("suser {}",username);
        log.info("pass {}",password);
        String successMsg = "User Logged in Successful: " + username;
        return ResponseEntity.ok(new SuccessResponse(successMsg, loginResponse));
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    // ErrorResponse class for custom error message
    @Data
    @AllArgsConstructor
    private static class ErrorResponse {
        private String message;
    }

    // success message
    @Data
    @AllArgsConstructor
    private static class SuccessResponse {
        private String message;
        private AuthenticationResponse data;
    }

    @Data
    @AllArgsConstructor
    public class LoginResponse {
        private boolean success;
        private String message;
    }
}
