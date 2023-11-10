package ua.com.dionysus.data.dto.order;

import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.BaseProduct;
import ua.com.dionysus.persistence.sql.models.order.Cart;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CartDto {

    private Date created;
    private List<ProductOrderDto> entries;
    private String price;

    public CartDto(Cart cart, List<BaseProduct> productVariants) {
        this.created = cart.getCreated();
        this.entries = productVariants.stream().map(ProductOrderDto::new).toList();
    }
}
