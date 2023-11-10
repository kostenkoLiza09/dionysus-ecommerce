package ua.com.dionysus.data.dto.product.plp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.models.product.TequilaProduct;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TequilaPLPDto {


    private Long id;
    private String tequilaBrandType;
    private String countryType;
    private String name;
    private String image;
    private BigDecimal price;

    private String tequilaStyleType;
    private String tequilaRegionType;


    public TequilaPLPDto (TequilaProduct product){
        this.id = product.getId();
        this.tequilaBrandType = product.getTequilaBrandType().getTequilaBrandType();
        this.name = product.getName();
        this.countryType = product.getCountryType().getCountryType();
        this.price = product.getPrice();
        this.tequilaRegionType = product.getTequilaRegionType().getTequilaRegionType();
        this.tequilaStyleType = product.getTequilaStyleType().getTequilaStyleType();
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

