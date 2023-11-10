package ua.com.dionysus.data.dto.product.plp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.models.product.WhiskeyProduct;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class WhiskeyPLPDto {


    private Long id;
    private String whiskeyBrandType;
    private String countryType;
    private String name;
    private String image;
    private BigDecimal price;

    private String whiskeyRegionType;
    private String whiskeyStyleType;

    public WhiskeyPLPDto (WhiskeyProduct product){
        this.id = product.getId();
        this.whiskeyBrandType = product.getWhiskeyBrandType().getWhiskeyBrandType();
        this.name = product.getName();
        this.countryType = product.getCountryType().getCountryType();
        this.price = product.getPrice();
        this.whiskeyRegionType = product.getWhiskeyRegionType().getWhiskeyRegion();
        this.whiskeyStyleType = product.getWhiskeyStyleType().getWhiskeyType();
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