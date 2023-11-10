package ua.com.dionysus.data.dto.product.plp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.models.product.RumProduct;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RumPLPDto {

    private Long id;
    private String rumBrandType;
    private String countryType;
    private String name;
    private String image;
    private BigDecimal price;

    private String rumStyleType;
    private String rumRegionType;

    public RumPLPDto (RumProduct product){
        this.id = product.getId();
        this.rumBrandType = product.getRumBrandType().getRumBrandType();
        this.name = product.getName();
        this.countryType = product.getCountryType().getCountryType();
        this.price = product.getPrice();
        this.rumStyleType = product.getRumStyleType().getRumStyleType();
        this.rumRegionType = product.getRumRegionType().getRumRegionType();
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
