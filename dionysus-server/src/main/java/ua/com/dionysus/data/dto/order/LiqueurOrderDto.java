package ua.com.dionysus.data.dto.order;

import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.models.product.LiqueurProduct;

@Getter
@Setter
public class LiqueurOrderDto extends ProductOrderDto{

    private String liqueurBrandType;
    private String liqueurStyleType;
    private String liqueurRegionType;

    public LiqueurOrderDto (LiqueurProduct product){
        super(product);
        this.liqueurBrandType = product.getLiqueurBrandType().getLiqueurBrandType();
        this.liqueurRegionType = product.getLiqueurRegionType().getLiqueurRegionType();
        this.liqueurStyleType  = product.getLiqueurStyleType().getLiqueurStyleType();
    }
}
