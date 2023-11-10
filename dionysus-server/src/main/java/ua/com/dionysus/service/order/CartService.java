package ua.com.dionysus.service.order;

import ua.com.dionysus.persistence.sql.models.order.Cart;
import ua.com.dionysus.persistence.sql.models.order.CartEntry;

import java.util.List;


public interface CartService {

    void add(CartEntry cartEntry);
    void update(CartEntry cartEntry);
    void remove(CartEntry cartEntry);
    void clear();

    Cart getActive();

    List<CartEntry> findByCart(Cart cart);

}
