package ua.com.dionysus.persistence.sql.dto;

import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.models.product.WineProduct;
import ua.com.dionysus.persistence.sql.type.CountryType;

@Getter
@Setter
public class WineDtoMini {

    private CountryType countryType;
    private String name;
    private WineProduct wineProduct;



    public WineDtoMini(CountryType countryType, String name, WineProduct wineProduct) {
        this.countryType = countryType;
        this.name = name;
        this.wineProduct = wineProduct;

    }
}
