package ua.com.dionysus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import ua.com.dionysus.persistence.sql.repository.users.UserRepository;
import ua.com.dionysus.persistence.sql.models.user.Role;
import ua.com.dionysus.persistence.sql.models.user.User;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    UserRepository repo;

//    @Test
//    public void testCreateUser() {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String rawPassword = "user1";
//        String encodedPassword = passwordEncoder.encode(rawPassword);
//
//        User newUser = new User("user1@gmail.com", encodedPassword);
//        newUser.setName("user1");
//        User savedUser = repo.save(newUser);
//
//        assertThat(savedUser).isNotNull();
//        assertThat(savedUser.getId()).isGreaterThan(0);
//    }


    @Test
    public void testAssignRolesToUser() {
        Integer userId = 6;

        User user = repo.findById(userId).get();
        user.addRole(new Role(5));
        user.addRole(new Role(6));

        User updateUser = repo.save(user);

        assertThat(updateUser.getRoles()).hasSize(2);
    }

}
