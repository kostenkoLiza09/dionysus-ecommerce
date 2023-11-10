package ua.com.dionysus.service.security;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.com.dionysus.persistence.sql.models.user.User;
import ua.com.dionysus.security.AuthRequest;
import ua.com.dionysus.security.AuthRequestUser;


@Service
public interface SecurityService {

     User findUserEmail ();

    ResponseEntity<?> login(AuthRequestUser request);

    ResponseEntity<?> register(AuthRequest request);


}
