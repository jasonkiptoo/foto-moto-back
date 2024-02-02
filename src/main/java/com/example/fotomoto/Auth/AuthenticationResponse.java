package com.example.fotomoto.Auth;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String message="djksdjksjkdsjkn";
    private String fName="djksdjksjkdsjkn";
    private String lName="djksdjksjkdsjkn";

}
