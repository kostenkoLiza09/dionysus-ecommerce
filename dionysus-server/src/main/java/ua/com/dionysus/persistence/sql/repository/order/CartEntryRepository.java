package ua.com.dionysus.persistence.sql.repository.order;

import org.springframework.stereotype.Repository;
import ua.com.dionysus.persistence.sql.models.order.Cart;
import ua.com.dionysus.persistence.sql.models.order.CartEntry;
import ua.com.dionysus.persistence.sql.repository.BaseEntityRepository;

import java.util.List;

@Repository
public interface CartEntryRepository extends BaseEntityRepository<CartEntry> {

    List<CartEntry> findAllByCart (Cart cart);
}