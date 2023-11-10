package ua.com.dionysus.data.dto.order;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.models.product.WineProduct;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class WineOrderDto extends ProductOrderDto{

    private String wineBrandType;
    private String  wineRegionType;
    private String wineStyleType;
    private String wineVarietalType;

    public WineOrderDto(WineProduct product) {
        super(product);
        this.wineBrandType = product.getWineBrandType().getWineBrandType();
        this.wineRegionType = product.getWineRegionType().getWineRegionType();
        this.wineStyleType = product.getWineStyleType().getWineType();
        this.wineVarietalType = product.getWineVarietalType().getWineVarietalType();
    }

}
