package ua.com.dionysus.service.order.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.dionysus.persistence.sql.models.order.Cart;
import ua.com.dionysus.persistence.sql.models.order.CartEntry;
import ua.com.dionysus.persistence.sql.repository.order.CartEntryRepository;
import ua.com.dionysus.persistence.sql.repository.order.CartRepository;
import ua.com.dionysus.service.security.SecurityService;
import ua.com.dionysus.persistence.sql.models.user.User;
import ua.com.dionysus.service.order.CartService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final SecurityService securityService;

    private final CartRepository cartRepository;
    private final CartEntryRepository cartEntryRepository;

    @Override
    public Cart getActive() {
        User user = securityService.findUserEmail();
        return cartRepository.findByUserAndActiveTrue(user)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }

    @Override
    public void add(CartEntry cartEntry) {
        User user = securityService.findUserEmail();
        Optional<Cart> optionalCart = cartRepository.findByUser(user);
        Cart cart = null;
        if (optionalCart.isEmpty()) {
            cart = new Cart();
            cart.setUser(user);
            cart = cartRepository.save(cart);
        } else {
            cart = optionalCart.get();
        }
        cartEntry.setCart(cart);
        cartEntryRepository.save(cartEntry);
    }

    @Override
    public void update(CartEntry cartEntry) {
        User user = securityService.findUserEmail();
        Optional<Cart> optionalCart = cartRepository.findByUser(user);
        if (optionalCart.isPresent()) {
            cartEntryRepository.save(cartEntry);
        }
    }

    @Override
    public void remove(CartEntry cartEntry) {
        User user = securityService.findUserEmail();
        Optional<Cart> optionalCart = cartRepository.findByUser(user);
        if (optionalCart.isPresent()) {
            cartEntryRepository.delete(cartEntry);
        }

    }

    @Override
    public void clear() {
        User user = securityService.findUserEmail();
        Optional<Cart> optionalCart = cartRepository.findByUser(user);
        optionalCart.ifPresent(cartRepository::delete);
    }

    @Override
    public List<CartEntry> findByCart(Cart cart) {
        return cartEntryRepository.findAllByCart(cart);
    }
}
