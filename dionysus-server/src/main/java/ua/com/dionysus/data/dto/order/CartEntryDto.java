package ua.com.dionysus.data.dto.order;

import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.BaseProduct;

@Getter
@Setter
public class CartEntryDto {

    private Long cartId;
    private BaseProduct baseProduct;
    private Integer quantity;
}