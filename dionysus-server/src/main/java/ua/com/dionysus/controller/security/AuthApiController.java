package ua.com.dionysus.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ua.com.dionysus.security.AuthRequest;
import ua.com.dionysus.security.AuthRequestUser;
import ua.com.dionysus.service.security.SecurityService;

import javax.validation.Valid;

@RestController
public class AuthApiController {


    @Autowired
    private SecurityService securityService;


    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequestUser request) {
        return securityService.login(request);
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody @Valid AuthRequest request) {
        return securityService.register(request);
    }
}



