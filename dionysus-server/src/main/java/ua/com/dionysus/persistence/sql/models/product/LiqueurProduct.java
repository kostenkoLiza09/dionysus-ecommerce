package ua.com.dionysus.persistence.sql.models.product;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ua.com.dionysus.persistence.sql.BaseProduct;
import ua.com.dionysus.persistence.sql.type.liqueur.LiqueurBrandType;
import ua.com.dionysus.persistence.sql.type.liqueur.LiqueurRegionType;
import ua.com.dionysus.persistence.sql.type.liqueur.LiqueurStyleType;

@Getter
@Setter
@Entity
@DiscriminatorValue("liqueur_products")
public class LiqueurProduct extends BaseProduct {


    @Enumerated(EnumType.STRING)
    @Column(name = "liqueur_brand", nullable = false, updatable = false)
    private LiqueurBrandType liqueurBrandType;

    @Enumerated(EnumType.STRING)
    @Column(name = "liqueur_region", nullable = false, updatable = false)
    private LiqueurRegionType liqueurRegionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "liqueur_style", nullable = false, updatable = false)
    private LiqueurStyleType liqueurStyleType;


}
