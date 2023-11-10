package ua.com.dionysus.data.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.dionysus.data.dto.BaseDto;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.type.AlcoholType;

@Getter
@Setter
@NoArgsConstructor
public class ProductImageDto extends BaseDto {

    private AlcoholType alcoholType;
    private Boolean mainImage;
    private String imageUrl;

    public ProductImageDto(ProductImage productImage) {
        setId(productImage.getId());
        this.imageUrl = productImage.getImageUrl();
        this.alcoholType = productImage.getAlcoholType();
        this.mainImage = productImage.getMainImage();
    }
}
