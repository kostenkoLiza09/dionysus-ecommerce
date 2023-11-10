package ua.com.dionysus.data.dto.product.plp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.models.product.WineProduct;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class WinePLPDto {


    private Long id;
    private String wineBrandType;
    private String countryType;
    private String name;
    private String image;
    private BigDecimal price;

    private String  wineRegionType;
    private String wineStyleType;
    private String wineVarietalType;

    public WinePLPDto (WineProduct product){
        this.id = product.getId();
        this.wineBrandType = product.getWineBrandType().getWineBrandType();
        this.name = product.getName();
        this.countryType = product.getCountryType().getCountryType();
        this.price = product.getPrice();
        this.wineRegionType = product.getWineRegionType().getWineRegionType();
        this.wineStyleType = product.getWineStyleType().getWineType();
        this.wineVarietalType = product.getWineVarietalType().getWineVarietalType();
        Set<ProductImage> productImageSet = product.getProductImages();
        if (CollectionUtils.isNotEmpty(productImageSet)){
            ProductImage productImage = productImageSet
                    .stream()
                    .filter(ProductImage :: getMainImage)
                    .findFirst().
                    orElseThrow(() -> new RuntimeException("main image not found"));
            this.image = productImage.getImageUrl();
        }
    }
}