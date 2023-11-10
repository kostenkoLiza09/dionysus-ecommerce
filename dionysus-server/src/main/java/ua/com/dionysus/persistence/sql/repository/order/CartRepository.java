package ua.com.dionysus.persistence.sql.repository.order;

import org.springframework.stereotype.Repository;
import ua.com.dionysus.persistence.sql.models.order.Cart;
import ua.com.dionysus.persistence.sql.repository.BaseEntityRepository;
import ua.com.dionysus.persistence.sql.models.user.User;

import java.util.Optional;

@Repository
public interface CartRepository extends BaseEntityRepository<Cart> {

    Optional<Cart> findByUser(User user);

    Optional<Cart> findByUserAndActiveTrue(User user);

}