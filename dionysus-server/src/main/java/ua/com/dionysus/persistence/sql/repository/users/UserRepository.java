package ua.com.dionysus.persistence.sql.repository.users;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.dionysus.persistence.sql.models.user.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email );

}