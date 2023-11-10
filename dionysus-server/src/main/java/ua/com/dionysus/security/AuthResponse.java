package ua.com.dionysus.security;

import lombok.*;

@Getter
@Setter
@Data
@Builder
public class AuthResponse {

    private String email;

    private String accessToken;

    public AuthResponse() { }

    public AuthResponse(String email, String accessToken) {
        this.email = email;
        this.accessToken = accessToken;
    }
}
