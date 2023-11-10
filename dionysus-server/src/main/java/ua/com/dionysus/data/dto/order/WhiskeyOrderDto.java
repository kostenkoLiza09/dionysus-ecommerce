package ua.com.dionysus.data.dto.order;

import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.models.product.RumProduct;
import ua.com.dionysus.persistence.sql.models.product.WhiskeyProduct;

@Getter
@Setter
public class WhiskeyOrderDto extends ProductOrderDto{

    private String whiskeyBrandType;
    private String whiskeyRegionType;
    private String whiskeyStyleType;

    public WhiskeyOrderDto (WhiskeyProduct product) {
        super(product);
        this.whiskeyBrandType = product.getWhiskeyBrandType().getWhiskeyBrandType();
        this.whiskeyRegionType = product.getWhiskeyRegionType().getWhiskeyRegion();
        this.whiskeyStyleType = product.getWhiskeyStyleType().getWhiskeyType();

    }
}
