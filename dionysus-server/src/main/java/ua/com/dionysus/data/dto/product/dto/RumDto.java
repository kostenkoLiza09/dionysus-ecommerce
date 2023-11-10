package ua.com.dionysus.data.dto.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import ua.com.dionysus.data.dto.BaseDto;

import ua.com.dionysus.persistence.sql.models.product.RumProduct;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class RumDto extends BaseDto {


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


    public RumDto (RumProduct product) {
        setId(product.getId());
        this.rumRegionType = product.getRumRegionType().getRumRegionType();
        this.rumStyleType = product.getRumStyleType().getRumStyleType();
        this.rumBrandType = product.getRumBrandType().getRumBrandType();

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
