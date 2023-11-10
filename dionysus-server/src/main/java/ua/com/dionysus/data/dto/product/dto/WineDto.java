package ua.com.dionysus.data.dto.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.dionysus.data.dto.BaseDto;
import ua.com.dionysus.persistence.sql.models.product.WineProduct;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class WineDto extends BaseDto {

    private String wineBrandType;
    private String wineRegionType;
    private String wineStyleType;
    private String wineVarietalType;


    private String countryType;
    private String name;
    private String description;
    private Integer age;
    private Double alcohol_by_volume;
    private BigDecimal price;

    private Integer quantity;
    private Integer volume;


    public WineDto(WineProduct product) {
        setId(product.getId());
        this.wineBrandType = product.getWineBrandType().getWineBrandType();
        this.wineRegionType = product.getWineRegionType().getWineRegionType();
        this.wineStyleType = product.getWineStyleType().getWineType();
        this.wineVarietalType = product.getWineVarietalType().getWineVarietalType();

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
