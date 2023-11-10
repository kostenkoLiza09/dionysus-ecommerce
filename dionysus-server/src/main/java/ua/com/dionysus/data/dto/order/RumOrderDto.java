package ua.com.dionysus.data.dto.order;

import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.models.product.RumProduct;

import java.math.BigDecimal;

@Getter
@Setter
public class RumOrderDto extends ProductOrderDto {


    private String rumBrandType;
    private String rumStyleType;
    private String rumRegionType;



    public RumOrderDto (RumProduct product) {
        super(product);
        this.rumBrandType = product.getRumBrandType().getRumBrandType();
        this.rumStyleType = product.getRumStyleType().getRumStyleType();
        this.rumRegionType = product.getRumRegionType().getRumRegionType();

    }
}
