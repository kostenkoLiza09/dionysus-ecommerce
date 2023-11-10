package ua.com.dionysus.security;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import ua.com.dionysus.persistence.sql.models.user.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthRequest {

    @NotNull
    @Email
    @Length(min = 5, max = 50)
    private String email;

    @NotNull @Length(min = 5, max = 10)
    private String password;

    @NotNull
    @Length(min = 2, max = 50)
    private String name;

    private Role role;


    public AuthRequest(String email, String password, String name, Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }
}
