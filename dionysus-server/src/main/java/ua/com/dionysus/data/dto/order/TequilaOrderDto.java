package ua.com.dionysus.data.dto.order;

import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.models.product.TequilaProduct;

@Getter
@Setter
public class TequilaOrderDto extends ProductOrderDto {
    private String tequilaBrandType;
    private String tequilaStyleType;
    private String tequilaRegionType;

    public TequilaOrderDto(TequilaProduct product) {
        super(product);
        this.tequilaBrandType = product.getTequilaBrandType().getTequilaBrandType();
        this.tequilaRegionType = product.getTequilaRegionType().getTequilaRegionType();
        this.tequilaStyleType = product.getTequilaStyleType().getTequilaStyleType();
    }
}
