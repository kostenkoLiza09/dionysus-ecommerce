package ua.com.dionysus.persistence.sql.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.dionysus.persistence.sql.models.user.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName (String name);

}
