package com.example.fotomoto.Responses;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AuthenticationResponse {
    private String token;
    private String message="djksdjksjkdsjkn";
    private String fName="djksdjksjkdsjkn";
    private String lName="djksdjksjkdsjkn";

}
