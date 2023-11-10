package ua.com.dionysus.facade.process;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.dionysus.data.dto.order.CartDto;
import ua.com.dionysus.data.dto.order.CartEntryDto;
import ua.com.dionysus.data.dto.order.ProductOrderDto;
import ua.com.dionysus.facade.order.CartFacade;
import ua.com.dionysus.persistence.sql.BaseProduct;
import ua.com.dionysus.persistence.sql.models.order.Cart;
import ua.com.dionysus.persistence.sql.models.order.CartEntry;
import ua.com.dionysus.service.order.CartService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CartFacadeImpl implements CartFacade {

    @Autowired
    private CartService cartService;

    @Override
    public CartDto findActive() {
        Cart cart = cartService.getActive();
        List<CartEntry> cartEntries = cartService.findByCart(cart);
        List<BaseProduct> productVariants = new ArrayList<>();
        BigDecimal price = new BigDecimal("00.00");
        for (CartEntry cartEntry : cartEntries) {
            BaseProduct productVariant = cartEntry.getBaseProduct();
            if (productVariant != null) {
                productVariants.add(productVariant);
                BigDecimal variantPrice = productVariant.getPrice();
                variantPrice = variantPrice.multiply(new BigDecimal(cartEntry.getQuantity()));
                price = price.add(variantPrice);
            }
        }
        CartDto cartDto = new CartDto(cart, productVariants);
        cartDto.setPrice(price.toString());
        for (int i = 0; i < cartEntries.size(); i++) {
            for (int i1 = 0; i1 < cartDto.getEntries().size(); i1++) {
                if (i == i1) {
                    ProductOrderDto productOrderDto = cartDto.getEntries().get(i);
                    productOrderDto.setQuantity(cartEntries.get(i).getQuantity());
                }
            }
        }
        return cartDto;
    }

    @Override
    public void add(CartEntryDto dto) {
        CartEntry cartEntry = new CartEntry();
        BaseProduct baseProduct = dto.getBaseProduct();
        cartEntry.setBaseProduct(baseProduct);
        cartEntry.setQuantity(dto.getQuantity());
        cartService.add(cartEntry);
    }

    @Override
    public void update(CartEntryDto dto) {
        CartEntry cartEntry = new CartEntry();
        BaseProduct baseProduct = dto.getBaseProduct();
        cartEntry.setBaseProduct(baseProduct);
        cartEntry.setQuantity(dto.getQuantity());
        cartService.update(cartEntry);
    }

    @Override
    public void remove(CartEntryDto dto) {
        CartEntry cartEntry = new CartEntry();
        BaseProduct baseProduct = dto.getBaseProduct();
        cartEntry.setBaseProduct(baseProduct);
        cartEntry.setQuantity(dto.getQuantity());
        cartService.remove(cartEntry);
    }

    @Override
    public void clear() {
        cartService.clear();

    }
}
