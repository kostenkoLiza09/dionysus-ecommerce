package ua.com.dionysus.data.dto.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.dionysus.data.dto.BaseDto;
import ua.com.dionysus.persistence.sql.models.product.WhiskeyProduct;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class WhiskeyDto extends BaseDto {

    private String whiskeyBrandType;
    private String whiskeyStyleType;
    private String whiskeyRegionType;

    private String countryType;
    private String name;
    private String description;
    private Integer age;
    private Double alcohol_by_volume;
    private BigDecimal price;

    private Integer quantity;
    private Integer volume;


    public WhiskeyDto(WhiskeyProduct product) {
        setId(product.getId());
        this.whiskeyRegionType = product.getWhiskeyRegionType().getWhiskeyRegion();
        this.whiskeyStyleType = product.getWhiskeyStyleType().getWhiskeyType();
        this.whiskeyBrandType = product.getWhiskeyBrandType().getWhiskeyBrandType();

        this.countryType = product.getCountryType().getCountryType();
        this.name = product.getName();
        this.description = product.getDescription();
        this.age = product.getAge();
        this.alcohol_by_volume = product.getAlcohol_by_volume();
        this.price = product.getPrice();

        this.quantity = product.getQuantity();
        this.volume = product.getVolume();
    }
}
