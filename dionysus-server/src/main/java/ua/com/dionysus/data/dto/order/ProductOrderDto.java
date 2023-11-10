package ua.com.dionysus.data.dto.order;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.dionysus.persistence.sql.BaseProduct;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.models.product.RumProduct;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class ProductOrderDto {

    private Long id;
    private String image;

    private String countryType;
    private String name;
    private String description;
    private Integer age;
    private Double alcohol_by_volume;
    private BigDecimal price;

    private Integer quantity;
    private Integer volume;

    public ProductOrderDto (BaseProduct product) {
        this.id = product.getId();

        this.countryType = product.getCountryType().getCountryType();
        this.name = product.getName();
        this.description = product.getDescription();
        this.age = product.getAge();
        this.alcohol_by_volume = product.getAlcohol_by_volume();
        this.price = product.getPrice();

        this.quantity = product.getQuantity();
        this.volume = product.getVolume();
        Set<ProductImage> productImageSet = product.getProductImages();
        if (CollectionUtils.isNotEmpty(productImageSet)) {
            ProductImage productImage = productImageSet
                    .stream()
                    .filter(ProductImage::getMainImage)
                    .findFirst().
                    orElseThrow(() -> new RuntimeException("main image not found"));
            this.image = productImage.getImageUrl();
        }
    }
}
