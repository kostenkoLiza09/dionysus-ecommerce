package ua.com.dionysus.persistence.sql.models.product;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.BaseProduct;
import ua.com.dionysus.persistence.sql.type.wine.WineBrandType;
import ua.com.dionysus.persistence.sql.type.wine.WineRegionType;
import ua.com.dionysus.persistence.sql.type.wine.WineStyleType;
import ua.com.dionysus.persistence.sql.type.wine.WineVarietalType;

@Getter
@Setter
@Entity
@DiscriminatorValue("wine_products")
public class WineProduct extends BaseProduct {

    @Enumerated(EnumType.STRING)
    @Column(name = "wine_brand", nullable = false, updatable = false)
    private WineBrandType wineBrandType;

    @Enumerated(EnumType.STRING)
    @Column(name = "wine_region", nullable = false, updatable = false)
    private WineRegionType wineRegionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "wine_style", nullable = false, updatable = false)
    private WineStyleType wineStyleType;

    @Enumerated(EnumType.STRING)
    @Column(name = "wine_varietal", nullable = false, updatable = false)
    private WineVarietalType wineVarietalType;
}