package com.example.fotomoto.Auth;

import com.example.fotomoto.Config.JwtService;
import com.example.fotomoto.Responses.AuthenticationResponse;
import com.example.fotomoto.user.Role;
import com.example.fotomoto.user.User;
import com.example.fotomoto.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

        public AuthenticationResponse authenticate (String username, String password){
            // Fetch user by username
            User user = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

            // Check if the provided password matches the stored password
            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new BadCredentialsException("Incorrect password");
            }

            // Generate JWT token
            String jwtToken = jwtService.generateToken(user);

            return AuthenticationResponse.builder().token(jwtToken).build();
        }


}