package ua.com.dionysus.data.dto.product.plp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.models.product.LiqueurProduct;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class LiqueurPLPDto {

    private Long id;
    private String liqueurBrandType;
    private String countryType;
    private String name;
    private String image;
    private BigDecimal price;

    private String liqueurStyleType;
    private String liqueurRegionType;


    public LiqueurPLPDto (LiqueurProduct product){
        this.id = product.getId();
        this.liqueurBrandType = product.getLiqueurBrandType().getLiqueurBrandType();
        this.name = product.getName();
        this.countryType = product.getCountryType().getCountryType();
        this.price = product.getPrice();
        this.liqueurStyleType = product.getLiqueurStyleType().getLiqueurStyleType();
        this.liqueurRegionType = product.getLiqueurRegionType().getLiqueurRegionType();
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
