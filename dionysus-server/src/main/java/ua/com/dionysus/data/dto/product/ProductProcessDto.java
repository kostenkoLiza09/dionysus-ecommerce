package ua.com.dionysus.data.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductProcessDto {

    private Long productId;
    private Set<Long> productImages;
}
