package ua.com.dionysus.data.dto.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.dionysus.data.dto.BaseDto;
import ua.com.dionysus.persistence.sql.models.product.TequilaProduct;

import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor
public class TequilaDto extends BaseDto {

    private String tequilaBrandType;
    private String tequilaStyleType;
    private String tequilaRegionType;

    private String countryType;
    private String name;
    private String description;
    private Integer age;
    private Double alcohol_by_volume;
    private BigDecimal price;

    private Integer quantity;
    private Integer volume;



    public TequilaDto(TequilaProduct product) {
        setId(product.getId());
        this.tequilaBrandType = product.getTequilaBrandType().getTequilaBrandType();
        this.tequilaRegionType = product.getTequilaRegionType().getTequilaRegionType();
        this.tequilaStyleType = product.getTequilaStyleType().getTequilaStyleType();

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