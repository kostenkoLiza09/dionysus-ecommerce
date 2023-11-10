package ua.com.dionysus.service.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.dionysus.exception.UserNotFoundException;
import ua.com.dionysus.persistence.sql.models.user.Role;
import ua.com.dionysus.persistence.sql.models.user.User;
import ua.com.dionysus.persistence.sql.repository.users.RoleRepository;
import ua.com.dionysus.persistence.sql.repository.users.UserRepository;
import ua.com.dionysus.security.*;
import ua.com.dionysus.service.security.SecurityService;
import ua.com.dionysus.util.SecurityUtil;

import java.util.HashSet;
@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtTokenUtil jwtUtil;


    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findUserEmail(){
        String username = SecurityUtil.getEmail();
        return repository
                .findByEmail(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

    }

    @Override
    public ResponseEntity<?> login(AuthRequestUser request) {
        try{
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken;
            accessToken = jwtUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @Override
    public ResponseEntity<?> register(AuthRequest request) {
        User user = null;
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (repository.existsByEmail(request.getEmail())) {
            return null;
        } else {
            if (!repository.existsByEmail(request.getEmail())) {
                user = new User();
                user.setEmail(request.getEmail());
                user.setName(request.getName());
                user.setPassword(passwordEncoder.encode(request.getPassword()));
                Role role = roleRepository.findByName("ROLE_CUSTOMER");
                HashSet<Role> roles= new HashSet<Role>();
                roles.add(role);
                user.setRoles(roles);
                repository.save(user);
            }
        }
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword())
        );
        String accessToken;
        assert user != null;
        accessToken = jwtUtil.generateAccessToken(user);
        AuthResponse response = new AuthResponse(user.getEmail(), accessToken);

        return ResponseEntity.ok(user);

    }
}
