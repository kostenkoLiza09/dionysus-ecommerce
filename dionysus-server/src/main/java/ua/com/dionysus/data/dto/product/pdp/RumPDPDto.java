package ua.com.dionysus.data.dto.product.pdp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.dionysus.persistence.sql.ProductImage;
import ua.com.dionysus.persistence.sql.models.product.RumProduct;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class RumPDPDto {


    private Long id;
    private String rumBrandType;
    private String rumStyleType;
    private String rumRegionType;

    private String countryType;
    private String name;
    private String description;
    private Integer age;
    private Double alcohol_by_volume;
    private BigDecimal price;

    private Integer quantity;
    private Integer volume;

    private Set<String> images;

    public RumPDPDto (RumProduct product) {
        this.id = product.getId();
        this.rumBrandType = product.getRumBrandType().getRumBrandType();
        this.rumStyleType = product.getRumStyleType().getRumStyleType();
        this.rumRegionType = product.getRumRegionType().getRumRegionType();

        this.countryType = product.getCountryType().getCountryType();
        this.name = product.getName();
        this.description = product.getDescription();
        this.age = product.getAge();
        this.alcohol_by_volume = product.getAlcohol_by_volume();
        this.price = product.getPrice();

        this.quantity = product.getQuantity();
        this.volume = product.getVolume();

        Set<ProductImage> productImages = product.getProductImages();
        if (CollectionUtils.isNotEmpty(productImages)) {
            this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
        }
        }
    }
