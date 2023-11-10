package ua.com.dionysus.security;

import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthRequestUser{

    @NotNull
    @Email
    @Length(min = 5, max = 50)
    private String email;

    @NotNull @Length(min = 5, max = 10)
    private String password;



    public AuthRequestUser(String email, String password) {
        this.email = email;
        this.password = password;

    }
}
