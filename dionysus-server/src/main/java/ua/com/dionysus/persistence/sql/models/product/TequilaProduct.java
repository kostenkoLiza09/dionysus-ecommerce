package ua.com.dionysus.persistence.sql.models.product;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.BaseProduct;
import ua.com.dionysus.persistence.sql.type.tequila.TequilaBrandType;
import ua.com.dionysus.persistence.sql.type.tequila.TequilaRegionType;
import ua.com.dionysus.persistence.sql.type.tequila.TequilaStyleType;

@Getter
@Setter
@Entity
@DiscriminatorValue("tequila_products")
public class TequilaProduct extends BaseProduct {

    @Enumerated(EnumType.STRING)
    @Column(name = "tequila_brand", nullable = false, updatable = false)
    private TequilaBrandType tequilaBrandType;

    @Enumerated(EnumType.STRING)
    @Column(name="tequila_region", nullable = false, updatable = false)
    private TequilaRegionType tequilaRegionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "tequila_style", nullable = false, updatable = false)
    private TequilaStyleType tequilaStyleType;

}
